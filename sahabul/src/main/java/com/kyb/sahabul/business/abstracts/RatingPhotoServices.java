package com.kyb.sahabul.business.abstracts;

import com.kyb.sahabul.entities.concretes.PitchPhoto;
import com.kyb.sahabul.entities.concretes.RatingPhoto;
import com.kyb.sahabul.entities.dto.PitchPhotoDto;
import com.kyb.sahabul.entities.dto.RatingPhotoDto;
import com.kyb.sahabul.entities.dto.createrequest.CreateRatingPhotoRequest;
import com.kyb.sahabul.entities.dto.createrequest.CreateRatingRequest;
import org.springframework.stereotype.Service;

import java.util.List;
public interface RatingPhotoServices {
    List<RatingPhotoDto> getAll();
    RatingPhotoDto getById(int id);
    RatingPhotoDto add(CreateRatingPhotoRequest createRatingPhotoRequest);
    void delete(RatingPhoto ratingPhoto);
}
