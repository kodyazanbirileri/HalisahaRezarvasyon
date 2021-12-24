package com.kyb.sahabul.api.controllers;

import com.kyb.sahabul.business.abstracts.RatingPhotoServices;
import com.kyb.sahabul.entities.concretes.RatingPhoto;
import com.kyb.sahabul.entities.dto.RatingPhotoDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/RatingPhoto")
public class RatingPhotoController {
    private final RatingPhotoServices ratingPhotoServices;

    public RatingPhotoController(RatingPhotoServices ratingPhotoServices) {
        this.ratingPhotoServices = ratingPhotoServices;
    }

    @GetMapping(value = "getAll")
    public ResponseEntity<List<RatingPhotoDto>> getAll() {
        return ResponseEntity.ok(ratingPhotoServices.getAll());
    }

    @GetMapping(value = "getById")
    public ResponseEntity<RatingPhotoDto> getById(@RequestParam int id) {
        return ResponseEntity.ok(ratingPhotoServices.getById(id));
    }

    @PostMapping(value = "add")
    public ResponseEntity<RatingPhotoDto> add(@RequestBody RatingPhoto ratingPhoto) {
        return ResponseEntity.ok(ratingPhotoServices.add(ratingPhoto));
    }
}
