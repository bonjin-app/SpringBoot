package kr.co.bonjin.restfulwebservice.user;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

@Service
public class UserDaoService {
    private static List<User> users = new ArrayList<>();

    private static int usersCount = 0;

    static {
        users.add(new User(1L, "Kenneth", new Date(), "pass1", "701010-1111111"));
        users.add(new User(2L, "Alice", new Date(), "pass2", "701010-2222222"));
        users.add(new User(3L, "Elena", new Date(), "pass3", "701010-3333333"));

        usersCount = users.size();
    }

    public List<User> findAll() {
        return users;
    }

    public User findOne(int id) {
        for (User user : users) {
            if (user.getId() == id) {
                return user;
            }
        }
        return null;
    }

    public User save(User user) {
        if (user.getId() == null) {
            user.setId((long) ++usersCount);
        }
        users.add(user);
        return user;
    }

    public User deleteById(int id) {
        Iterator<User> iterator = users.iterator();

        while (iterator.hasNext()) {
            User user = iterator.next();
            if (user.getId() == id) {
                iterator.remove();
                return user;
            }
        }
        return null;
    }
}
