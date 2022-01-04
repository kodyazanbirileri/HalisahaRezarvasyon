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
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private boolean status;
    private List<ReservationDto> reservations;

}
