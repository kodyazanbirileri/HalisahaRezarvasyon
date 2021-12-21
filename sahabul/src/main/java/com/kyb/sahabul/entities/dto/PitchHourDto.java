package com.kyb.sahabul.entities.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PitchHourDto {

    private int id;
    private HourDto hour;

}
