package com.kyb.sahabul.entities.dto.createrequest;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateRatingRequest {

    private int rate;
    private String rateDetail;
    private int reservationId;
    private List<CreateRatingPhotoForRatingRequest> ratingPhotoForRatings;

}
