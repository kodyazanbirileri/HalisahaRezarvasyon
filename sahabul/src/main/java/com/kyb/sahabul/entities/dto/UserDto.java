package com.kyb.sahabul.entities.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {

    private int id;
    private String password;
    private String email;
    private Date userCreated;
    private boolean status;
    private int phoneNumber;
    private List<ReservationDto> reservations;

}
