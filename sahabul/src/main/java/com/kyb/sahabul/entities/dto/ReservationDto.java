package com.kyb.sahabul.entities.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReservationDto {


    private int id;
    private String reservationDate;
    private String note;
    private boolean status;
    private String pitchName;
    private HourDto reservationHour;
    private int pitchId;
    private int userId;

}
