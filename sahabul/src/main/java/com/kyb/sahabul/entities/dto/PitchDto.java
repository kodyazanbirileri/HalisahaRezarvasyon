package com.kyb.sahabul.entities.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PitchDto {

    private int id;
    private String pitchName;
    private String address;
    private String pitchNumber;
    private String city;
    private String district;
    private boolean status;
    private List<String> pitchProperties;
    private List<String> pitchPhotoUrls;
    private List<ReservationForPitchDto> reservations;



}
