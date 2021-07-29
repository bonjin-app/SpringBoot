package kr.co.bonjin.restfulwebservice.user;

import com.fasterxml.jackson.annotation.JsonFilter;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import kr.co.bonjin.restfulwebservice.post.Post;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
//@JsonFilter("UserInfo")
@ApiModel(description = "사용자 상세 정보를 위한 도메인 객체")
@Entity
public class User {

    @Id
    @GeneratedValue()
    private Long id;

    @Size(min = 2, message = "Name은 2글자 이상을 입력해 주세요.")
    @ApiModelProperty(notes = "사용자 이름을 입력해주세요.")
    private String name;

    @Past
    @ApiModelProperty(notes = "사용자 등록일을 입력해주세요.")
    private Date joinDate;

    @ApiModelProperty(notes = "사용자 패스워드를 입력해주세요.")
    private String password;

    @ApiModelProperty(notes = "사용자 주민번호를 입력해주세요.")
    private String ssn;

    @OneToMany(mappedBy = "user")
    private List<Post> postList;

    public User(Long id, String name, @Past Date joinDate, String password, String ssn) {
        this.id = id;
        this.name = name;
        this.joinDate = joinDate;
        this.password = password;
        this.ssn = ssn;
        this.postList = new ArrayList<>();
    }
}
