package com.kyb.sahabul.api.controllers;

import com.kyb.sahabul.business.abstracts.UserService;
import com.kyb.sahabul.entities.concretes.User;
import com.kyb.sahabul.entities.dto.UserDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/user")
public class UserController {

    private final UserService userService;


    UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/getAll")
    public ResponseEntity<List<UserDto>> getAll(){
       return ResponseEntity.ok(userService.getAll());
    }



    @PostMapping(value = "/add")
    void add(@RequestBody User user)
    {
        this.userService.add(user);
    }
}
