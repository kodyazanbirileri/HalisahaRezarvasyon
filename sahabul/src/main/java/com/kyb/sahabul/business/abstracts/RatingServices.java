package com.kyb.sahabul.business.abstracts;

import com.kyb.sahabul.entities.concretes.Rating;
import com.kyb.sahabul.entities.dto.RatingDto;

import java.util.List;

public interface RatingServices {
    List<RatingDto> getAll();
    RatingDto getById(int id);
    RatingDto add(Rating rating);
    void delete(Rating rating);
}
