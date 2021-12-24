package com.kyb.sahabul.api.controllers;

import com.kyb.sahabul.business.abstracts.PitchPhotoServices;
import com.kyb.sahabul.entities.concretes.PitchPhoto;
import com.kyb.sahabul.entities.dto.PitchPhotoDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/PitchPhoto")
public class PitchPhotoController {
    private final PitchPhotoServices pitchPhotoServices;

    public PitchPhotoController(PitchPhotoServices pitchPhotoServices) {
        this.pitchPhotoServices = pitchPhotoServices;
    }

    @GetMapping(value = "getAll")
    public ResponseEntity<List<PitchPhotoDto>> getAll() {
        return ResponseEntity.ok(pitchPhotoServices.getAll());
    }

    @GetMapping(value = "getById")
    public ResponseEntity<PitchPhotoDto> getById(int id) {
        return ResponseEntity.ok(pitchPhotoServices.getById(id));
    }

    @PostMapping(value = "add")
    public ResponseEntity<PitchPhotoDto> add(@RequestBody PitchPhoto pitchPhoto) {
        return ResponseEntity.ok(pitchPhotoServices.add(pitchPhoto));
    }
}
