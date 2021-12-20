package com.kyb.sahabul.entities.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class RatingPhotoDto {

    private int id;
    private String photoPath;
    private List<RatingDto> ratings;

}
