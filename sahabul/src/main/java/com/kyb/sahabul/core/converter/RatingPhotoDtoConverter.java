package com.kyb.sahabul.core.converter;

import com.kyb.sahabul.entities.concretes.RatingPhoto;
import com.kyb.sahabul.entities.dto.RatingPhotoDto;
import org.springframework.stereotype.Component;

@Component
public class RatingPhotoDtoConverter {

    public RatingPhotoDto convert(RatingPhoto from){
        return new RatingPhotoDto(
                from.getId(),
                from.getPhotoPath()
        );
    }
}
