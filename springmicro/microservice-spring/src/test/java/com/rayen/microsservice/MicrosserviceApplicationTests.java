package com.rayen.microsservice;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.rayen.microsservice.entities.User;
import com.rayen.microsservice.service.UserService;

@SpringBootTest
class MicrosserviceApplicationTests {
    @Autowired
    UserService userService;

    @Test
    void testRegisterUserAndSendVerificationCode() {
        User user = new User(null, "rayentroudi", "26983014rayen@gmail.com", "123456", null, false, null);
        userService.saveUser(user);
    }

    @Test
    void activatedUserAccount() {
        User user = userService.activateUser("rayentroudi", "4868");
        System.out.println(user);
    }

    @Test
    void testDeleteUser() {
        userService.deleteUser(3);
    }
}
