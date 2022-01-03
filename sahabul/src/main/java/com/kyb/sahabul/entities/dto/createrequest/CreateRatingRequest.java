package com.kyb.sahabul.entities.dto.createrequest;

import java.util.List;

public class CreateRatingRequest {

    private int rate;
    private String rateDetail;
    private int reservationId;
    private List<CreateRatingPhotoForRatingRequest> ratingPhotoForRatings;

}
