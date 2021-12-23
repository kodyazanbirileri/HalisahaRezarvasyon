package com.kyb.sahabul.api.controllers;

import com.kyb.sahabul.business.abstracts.PropertyServices;
import com.kyb.sahabul.entities.concretes.Property;
import com.kyb.sahabul.entities.dto.PropertyDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/property")
public class PropertyController {
    private final PropertyServices propertyServices;


    public PropertyController(PropertyServices propertyServices) {
        this.propertyServices = propertyServices;
    }

    public ResponseEntity<PropertyDto> getById(@RequestParam int id) {
        return ResponseEntity.ok(propertyServices.getById(id));
    }

    @GetMapping(value = "getAll")
    public ResponseEntity<List<PropertyDto>> getAll() {
        return ResponseEntity.ok(propertyServices.getAll());
    }

    @PostMapping(value = "add")
    public ResponseEntity<PropertyDto> add(@RequestParam Property property) {
        return ResponseEntity.ok(propertyServices.add(property));
    }

}
