package com.kyb.sahabul.api.controllers;

import com.kyb.sahabul.business.abstracts.UserServices;
import com.kyb.sahabul.entities.concretes.User;
import com.kyb.sahabul.entities.dto.UserDto;
import com.kyb.sahabul.entities.dto.createrequest.CreateUserRequest;
import com.kyb.sahabul.entities.dto.updaterequest.UpdateUserRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/user")
public class UserController {

    private final UserServices userServices;


    UserController(UserServices userServices) {
        this.userServices = userServices;
    }

    @GetMapping(value = "/getAll")
    public ResponseEntity<List<UserDto>> getAll() {
       return ResponseEntity.ok(userServices.getAll());
    }

    @PostMapping(value = "/update")
    public ResponseEntity<UserDto> update(@RequestBody UpdateUserRequest  updateUserRequest) {
        return ResponseEntity.ok(userServices.update(updateUserRequest));
    }

    @PostMapping(value = "/add")
    ResponseEntity<UserDto> add(@RequestBody CreateUserRequest createUserRequest) {
        return ResponseEntity.ok(userServices.add(createUserRequest));
    }

    @PostMapping(value = "/delete")
    ResponseEntity<UserDto> add(@RequestParam int userId) {
        return ResponseEntity.ok(userServices.delete(userId));
    }

}
