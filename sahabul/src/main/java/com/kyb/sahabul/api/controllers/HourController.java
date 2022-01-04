package com.kyb.sahabul.api.controllers;

import com.kyb.sahabul.business.abstracts.HourServices;
import com.kyb.sahabul.entities.dto.HourDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

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
