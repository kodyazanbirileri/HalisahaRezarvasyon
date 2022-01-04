package com.kyb.sahabul.api.controllers;

import com.kyb.sahabul.business.abstracts.RatingServices;
import com.kyb.sahabul.entities.concretes.Rating;
import com.kyb.sahabul.entities.dto.RatingDto;
import com.kyb.sahabul.entities.dto.createrequest.CreateRatingRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/rating")
public class RatingController {
    private final RatingServices ratingServices;

    public RatingController(RatingServices ratingServices) {
        this.ratingServices = ratingServices;
    }

    @GetMapping(value = "/getAll")
    public ResponseEntity<List<RatingDto>> getAll() {
        return ResponseEntity.ok(ratingServices.getAll());
    }

    @GetMapping(value = "/getById")
    public ResponseEntity<RatingDto> getById(@RequestParam int id) {
        return ResponseEntity.ok(ratingServices.getById(id));
    }

    @PostMapping(value = "/add")
    public ResponseEntity<RatingDto> add(@RequestBody CreateRatingRequest createRatingRequest  ) {

        return ResponseEntity.ok(ratingServices.add(createRatingRequest));
    }

    @PostMapping(value = "/delete")
    public ResponseEntity<RatingDto> add(@RequestParam int ratingId ) {

        return ResponseEntity.ok(ratingServices.delete(ratingId));
    }

}
