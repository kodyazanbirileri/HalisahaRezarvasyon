package com.kyb.sahabul.api.controllers;

import com.kyb.sahabul.business.abstracts.ComplainedRatingServices;
import com.kyb.sahabul.entities.concretes.ComplainedRating;
import com.kyb.sahabul.entities.dto.ComplainedRatingDto;
import com.kyb.sahabul.entities.dto.createrequest.CreateComplainedRating;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.CompletionService;

@RestController
@RequestMapping(value = "api/ComplainedRating")
public class ComplainedRatingController {
    private final ComplainedRatingServices complainedRatingServices;

    public ComplainedRatingController(ComplainedRatingServices complainedRatingServices) {
        this.complainedRatingServices = complainedRatingServices;
    }

    @GetMapping(value = "/getAll")
    public ResponseEntity<List<ComplainedRatingDto>> getAll(){
        return ResponseEntity.ok(complainedRatingServices.getAll());
    }
    @GetMapping(value = "/getById")
    public  ResponseEntity<ComplainedRatingDto> getById(@RequestParam int id){
        return ResponseEntity.ok(complainedRatingServices.getById(id));
    }

    @PostMapping(value = "/add")
    public  ResponseEntity<ComplainedRatingDto> add(@RequestBody CreateComplainedRating createComplainedRating){
        return ResponseEntity.ok(complainedRatingServices.add(createComplainedRating));
    }

}
