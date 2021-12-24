package com.kyb.sahabul.api.controllers;

import com.kyb.sahabul.business.abstracts.PitchHourServices;
import com.kyb.sahabul.entities.concretes.PitchHour;
import com.kyb.sahabul.entities.dto.PitchHourDto;
import jdk.dynalink.linker.LinkerServices;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/PitchHour")
public class PitchHourController {
    private final PitchHourServices pitchHourServices;

    public PitchHourController(PitchHourServices pitchHourServices) {
        this.pitchHourServices = pitchHourServices;
    }

    @GetMapping(value = "getAll")
    public ResponseEntity<List<PitchHourDto>> getAll() {
        return ResponseEntity.ok(pitchHourServices.getAll());
    }

    @GetMapping(value = "getById")
    public ResponseEntity<PitchHourDto> getById(int id) {
        return ResponseEntity.ok(pitchHourServices.getById(id));
    }

    @PostMapping(value = "add")
    public ResponseEntity<PitchHourDto> add(@RequestBody PitchHour pitchHour) {
        return ResponseEntity.ok(pitchHourServices.add(pitchHour));
    }
}
