package com.kris.SecurityDemo.Controller;

import com.kris.SecurityDemo.Model.Users;
import com.kris.SecurityDemo.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public Users register(@RequestBody Users user){
        return userService.register(user);
    }

    @PostMapping("/login")
    public String verify(@RequestBody Users user){
        System.out.println("controller verify");
        System.out.println(user.getUsername());
        System.out.println(user.getPassword());
        return userService.verify(user);
    }

}
