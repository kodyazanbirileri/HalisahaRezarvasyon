package com.kyb.sahabul.entities.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ComplainedRatingDto {

    private int id;
    private boolean isConfirmed;
    private ReservationDto reservation;


}
