package com.jarq.login.rest;

import com.jarq.login.entity.User;
import com.jarq.login.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserRestController {

    // autowire the UserService
    @Autowired
    private UserService userService;

    // add mapping for GET /users
    @GetMapping("/users")
    public List<User> getUsers() {
        return userService.getUsers();
    }

    // add mapping for GET /users/{userId}
    @GetMapping("/users/{userId}")
    public User getUser(@PathVariable int userId) {
        User theUser= userService.getUser(userId);
        return theUser;
    }


}
