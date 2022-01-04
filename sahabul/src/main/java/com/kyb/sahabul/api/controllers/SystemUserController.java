package com.kyb.sahabul.api.controllers;

import com.kyb.sahabul.business.abstracts.SystemUserServices;
import com.kyb.sahabul.entities.concretes.SystemUser;
import com.kyb.sahabul.entities.dto.SystemUserDto;
import com.kyb.sahabul.entities.dto.createrequest.CreateSystemUserRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/SystemUser")
public class SystemUserController {

    private final SystemUserServices systemUserServices;

    public SystemUserController(SystemUserServices systemUserServices) {
        this.systemUserServices = systemUserServices;
    }
    @PostMapping(value = "add")
    public ResponseEntity<SystemUserDto> add(@RequestBody CreateSystemUserRequest createSystemUserRequest){
        return ResponseEntity.ok(systemUserServices.add(createSystemUserRequest));
    }

    @GetMapping(value = "/getAll")
    public ResponseEntity<List<SystemUserDto>> getAll(){
        return ResponseEntity.ok(systemUserServices.getAll());
    }


    @GetMapping(value = "getById")
    public SystemUserDto getById(@RequestParam int id){
        return systemUserServices.getById(id);
    }



}

