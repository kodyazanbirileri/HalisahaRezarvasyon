package com.kyb.sahabul.api.controllers;

import com.kyb.sahabul.business.abstracts.CityServices;
import com.kyb.sahabul.entities.dto.CityDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping
@RestController(value = "api/cities")
public class CityController {

    private final CityServices cityServices;


    public CityController(CityServices cityServices) {
        this.cityServices = cityServices;
    }

    @GetMapping(value = "/getAll")
    public ResponseEntity<List<CityDto>> getAll() {
        return ResponseEntity.ok(cityServices.getAll());
    }

    @GetMapping(value = "/getById")
    public ResponseEntity<CityDto> getById(@RequestParam int id) {
        return ResponseEntity.ok(cityServices.getById(id));
    }


}
