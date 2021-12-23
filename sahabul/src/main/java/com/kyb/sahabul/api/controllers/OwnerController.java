package com.kyb.sahabul.api.controllers;

import com.kyb.sahabul.business.abstracts.OwnerServices;
import com.kyb.sahabul.entities.concretes.Owner;
import com.kyb.sahabul.entities.dto.OwnerDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/owner")
public class OwnerController {

    private final OwnerServices ownerServices;


    public OwnerController(OwnerServices ownerServices) {
        this.ownerServices = ownerServices;
    }

    @PostMapping(value = "add")
    public ResponseEntity<OwnerDto> add(@RequestBody Owner owner){
        return ResponseEntity.ok(ownerServices.add(owner));
    }

    @GetMapping(value = "/getAll")
    public ResponseEntity<List<OwnerDto>> getAll(){
        return ResponseEntity.ok(ownerServices.getAll());
    }


    @GetMapping(value = "getById")
    public OwnerDto getById(@RequestParam int id){
        return ownerServices.getById(id);
    }



}
