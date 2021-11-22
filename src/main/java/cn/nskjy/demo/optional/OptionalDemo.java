package cn.nskjy.demo.optional;

import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;

import java.util.Optional;

@Slf4j
public class OptionalDemo {

    public static void main(String[] args) {
        User user = new User();
        user.setId(Integer.valueOf(1));
        user.setName("y1");
        User user2 = null;
        log.info("调用了orElse()");
        Optional.ofNullable(user).orElse(createUser());
        log.info("调用了orElseGet()");
        Optional.ofNullable(user).orElseGet(() ->createUser());


    }

    public static User createUser() {
        User user = new User();
        user.setId(Integer.valueOf(2));
        user.setName("y2");
        System.out.println("创建了user类");
        return user;
    }
}
