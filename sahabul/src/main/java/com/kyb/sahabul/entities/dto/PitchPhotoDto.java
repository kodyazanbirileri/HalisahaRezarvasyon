package com.kyb.sahabul.entities.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PitchPhotoDto {

    private int id;
    private String photoPath;
    private PitchDto pitch;

}
