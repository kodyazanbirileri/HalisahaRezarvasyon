package com.kyb.sahabul.entities.dto.createrequest;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateRatingPhotoRequest {

    private String photoPath;
    private int ratingId;

}
