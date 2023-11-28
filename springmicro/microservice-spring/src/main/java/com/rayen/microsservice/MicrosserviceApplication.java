package com.rayen.microsservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.rayen.microsservice.service.UserService;


@SpringBootApplication
public class MicrosserviceApplication {

    public static void main(String[] args) {
        SpringApplication.run(MicrosserviceApplication.class, args);
    }
    @Autowired
    UserService userService;
//    /* @PostConstruct
//     void init_users() {



// //ajouter les rôles
//         userService.addRole(new Role(null,"ADMIN"));
//         userService.addRole(new Role(null,"USER"));

// //ajouter les utilisateurs roles

//         userService.addRoleToUser(1L,new Role(null,"ADMIN"));
//  User(null,"admin","123",true,null))
//  User(null,"rayen","123",true,null));
// userService.addRoleToUser("rayen", "USER");
// userService.addRoleToUser("admin", "ADMIN");
//     }*/



    @Bean
    BCryptPasswordEncoder getBCE() {
        return new BCryptPasswordEncoder();
    }

}
