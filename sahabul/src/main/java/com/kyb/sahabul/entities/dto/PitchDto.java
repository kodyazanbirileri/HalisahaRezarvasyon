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
    private int pitchNumber;
    private CityDto city;
    private DistrictDto district;
    private List<PitchPropertyDto> pitchProperties;
    private List<ReservationDto> reservations;
    private List<PitchHourDto> pitchHours;
    private List<PitchPhotoDto> pitchPhotos;



}
