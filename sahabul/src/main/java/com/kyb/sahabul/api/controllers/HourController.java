package com.kyb.sahabul.api.controllers;

import com.kyb.sahabul.business.abstracts.HourServices;
import com.kyb.sahabul.entities.dto.HourDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "api/hours")
public class HourController {

    private final HourServices hourServices;

    public HourController(HourServices hourServices) {
        this.hourServices = hourServices;
    }

    @GetMapping(value = "/getAll")
    public ResponseEntity<List<HourDto>> getAll()
    {
        return ResponseEntity.ok(hourServices.getAll());
    }

}
