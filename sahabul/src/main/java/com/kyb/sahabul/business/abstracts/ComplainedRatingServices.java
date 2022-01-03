package com.kyb.sahabul.business.abstracts;

import com.kyb.sahabul.entities.concretes.ComplainedRating;
import com.kyb.sahabul.entities.dto.ComplainedRatingDto;
import com.kyb.sahabul.entities.dto.createrequest.CreateComplainedRating;

import java.util.List;

public interface ComplainedRatingServices {
    List<ComplainedRatingDto> getAll();
    ComplainedRatingDto getById(int id);
    ComplainedRatingDto add(CreateComplainedRating from);
    void delete(ComplainedRating complainedRating);
}
