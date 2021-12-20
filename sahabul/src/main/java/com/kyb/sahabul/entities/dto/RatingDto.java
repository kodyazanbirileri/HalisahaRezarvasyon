package com.kyb.sahabul.entities.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RatingDto {

    private int id;
    private int rate;
    private String rateDetail;
    private boolean status;
    private List<RatingPhotoDto> ratingPhotos;
    private ReservationDto reservation;


}
