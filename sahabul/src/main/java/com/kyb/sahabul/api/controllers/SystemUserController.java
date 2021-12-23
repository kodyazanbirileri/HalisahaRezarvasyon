package com.kyb.sahabul.api.controllers;

import com.kyb.sahabul.business.abstracts.SystemUserService;
import com.kyb.sahabul.entities.concretes.SystemUser;
import com.kyb.sahabul.entities.dto.SystemUserDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/SystemUser")
public class SystemUserController {

    private final SystemUserService systemUserService;

    public SystemUserController(SystemUserService systemUserService) {
        this.systemUserService = systemUserService;
    }
    @PostMapping(value = "add")
    public ResponseEntity<SystemUserDto> addOwner(@RequestParam SystemUser systemUser){
        return ResponseEntity.ok(systemUserService.add(systemUser));
    }

    @GetMapping(value = "/getAll")
    public ResponseEntity<List<SystemUserDto>> getAllOwner(){
        return ResponseEntity.ok(systemUserService.getAll());
    }


    @GetMapping(value = "getById")
    public SystemUserDto getByIdOwnerDto(@RequestParam int id){
        return systemUserService.getById(id);
    }



}

