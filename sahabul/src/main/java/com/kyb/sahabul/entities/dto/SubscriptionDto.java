package com.kyb.sahabul.entities.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SubscriptionDto {

    private int id;
    private boolean status;
    private ReservationDto reservation;

}
