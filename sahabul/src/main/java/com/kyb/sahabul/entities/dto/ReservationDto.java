package com.kyb.sahabul.entities.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReservationDto {


    private int id;
    private LocalDate reservationDate;
    private String note;
    private boolean status;
    private HourDto reservationHour;
    private int pitchId;
    private int userId;

}
