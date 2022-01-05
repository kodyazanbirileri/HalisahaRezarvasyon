package com.kyb.sahabul.api.controllers;

import com.kyb.sahabul.business.abstracts.DistrictServices;
import com.kyb.sahabul.entities.dto.DistrictDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "api/disctricts")
public class DistrictController {

    private final DistrictServices districtServices;

    public DistrictController(DistrictServices districtServices) {
        this.districtServices = districtServices;
    }


    @GetMapping(value = "/getAll")
    public ResponseEntity<List<DistrictDto>> getAll() {
        return ResponseEntity.ok(districtServices.getAll());
    }

    @GetMapping(value = "/getById")
    public ResponseEntity<DistrictDto> getById(@RequestParam int id) {
        return ResponseEntity.ok(districtServices.getById(id));
    }

}
