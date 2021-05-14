package kr.co.bonjin.fcm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

@SpringBootApplication
public class FcmApplication {

    public static void main(String[] args) throws IOException {
        SpringApplication.run(FcmApplication.class, args);

        Messaging.message(args);
    }

}
