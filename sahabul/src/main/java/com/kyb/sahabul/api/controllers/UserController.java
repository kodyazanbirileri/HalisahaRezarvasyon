package com.kyb.sahabul.api.controllers;

import com.kyb.sahabul.business.abstracts.UserService;
import com.kyb.sahabul.business.concretes.UserManager;
import com.kyb.sahabul.entities.concretes.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(name = "/api/user")
public class UserController {

    private final UserService userService;


    UserController(UserService userService)
    {
        this.userService = userService;
    }


    @PostMapping(name = "/add")
    void add(@RequestBody User user)
    {
        this.userService.addUser(user);
    }
}
