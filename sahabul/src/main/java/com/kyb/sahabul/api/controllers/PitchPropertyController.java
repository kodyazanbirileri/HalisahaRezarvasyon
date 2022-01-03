package com.kyb.sahabul.api.controllers;

import com.kyb.sahabul.business.abstracts.PitchPropertyService;
import com.kyb.sahabul.entities.concretes.PitchProperty;
import com.kyb.sahabul.entities.dto.PitchPropertyDto;
import com.kyb.sahabul.entities.dto.createrequest.CreatePitchPropertyRequest;
import com.kyb.sahabul.entities.dto.createrequest.CreatePitchRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/PitchProperty")
public class PitchPropertyController {
    private final PitchPropertyService pitchPropertyService;

    public PitchPropertyController(PitchPropertyService pitchPropertyService) {
        this.pitchPropertyService = pitchPropertyService;
    }

    @GetMapping(value = "getAll")
    public ResponseEntity<List<PitchPropertyDto>> getAll(){
        return ResponseEntity.ok(pitchPropertyService.getAll());
    }

    @GetMapping(value = "getById")
    public ResponseEntity<PitchPropertyDto> getById(@RequestParam int id){
        return ResponseEntity.ok(pitchPropertyService.getById(id));
    }

    @PostMapping(value = "add")
    public ResponseEntity<PitchPropertyDto> add(@RequestBody CreatePitchPropertyRequest createPitchPropertyRequest) {
        return ResponseEntity.ok(pitchPropertyService.add(createPitchPropertyRequest));
    }
}
