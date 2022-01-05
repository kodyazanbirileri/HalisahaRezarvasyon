package com.kyb.sahabul.entities.dto.createrequest;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateReservationRequest {

    private LocalDate reservationDate;
    private String note;
    private int hourId;
    private int pitchId;
    private int userId;

}
