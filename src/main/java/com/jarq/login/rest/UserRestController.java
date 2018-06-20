package com.jarq.login.rest;

import com.jarq.login.entity.User;
import com.jarq.login.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

        if (theUser == null) {
            throw new UserNotFoundException("User id not found - " + userId);
        }
        return theUser;
    }

    // add mapping for POST /users - add new user
    @PostMapping("/users")
    public User addUser(@RequestBody User theUser) {

        // set id to 0 - is force a save new item .. instead update
        theUser.setId(0);

        userService.saveUser(theUser);

        return theUser;
    }

    // add mapping for PUT /users - update existing user
    @PutMapping("/users")
    public User updateUser(@RequestBody User theUser) {

        userService.saveUser(theUser);
        return theUser;
    }

    // add mapping for DELETE /users/{userId} - delete user
    @DeleteMapping("/users/{userId}")
    public String deleteUser(@PathVariable int userId) {

        User tempUser = userService.getUser(userId);

        if (tempUser == null) {
            throw new UserNotFoundException("User id not found - " + userId);
        }

        userService.deleteUser(userId);

        return "Deleted user id - " + userId;
    }
}
