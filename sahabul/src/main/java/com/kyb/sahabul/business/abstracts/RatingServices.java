package com.kyb.sahabul.business.abstracts;

import com.kyb.sahabul.entities.concretes.Rating;
import com.kyb.sahabul.entities.dto.RatingDto;
import com.kyb.sahabul.entities.dto.createrequest.CreateRatingPhotoRequest;
import com.kyb.sahabul.entities.dto.createrequest.CreateRatingRequest;

import java.util.List;

public interface RatingServices {
    List<RatingDto> getAll();
    Rating findById(int id);
    RatingDto getById(int id);
    RatingDto add(CreateRatingRequest createRatingRequest);
    RatingDto delete(int ratingId);
}
