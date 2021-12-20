package com.kyb.sahabul.entities.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PitchPropertyDto {

    private int id;
    private PitchDto pitch;
    private PropertyDto property;

}
