package com.kyb.sahabul.api.controllers;

import com.kyb.sahabul.business.abstracts.PitchServices;
import com.kyb.sahabul.entities.concretes.Pitch;
import com.kyb.sahabul.entities.dto.PitchDto;
import com.kyb.sahabul.entities.dto.createrequest.CreatePitchRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/pitch")
public class PitchController {
    private final PitchServices pitchServices;


    public PitchController(PitchServices pitchServices) {
        this.pitchServices = pitchServices;
    }

    @PostMapping(value = "add")
    public ResponseEntity<PitchDto> add(@RequestBody CreatePitchRequest createPitchRequest){
        return ResponseEntity.ok(pitchServices.add(createPitchRequest));
    }

    @GetMapping(value = "/getAll")
    public ResponseEntity<List<PitchDto>> getAll(){
        return ResponseEntity.ok(pitchServices.getAll());
    }


    @GetMapping(value = "getById")
    public PitchDto getById(@RequestParam int id){
        return pitchServices.getById(id);
    }
}
