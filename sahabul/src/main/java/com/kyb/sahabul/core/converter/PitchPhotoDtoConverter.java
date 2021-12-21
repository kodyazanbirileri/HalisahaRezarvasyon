package com.kyb.sahabul.core.converter;

import com.kyb.sahabul.entities.concretes.PitchPhoto;
import com.kyb.sahabul.entities.dto.PitchPhotoDto;
import org.springframework.stereotype.Component;

@Component
public class PitchPhotoDtoConverter {

    public PitchPhotoDto convert(PitchPhoto from)
    {
        return new PitchPhotoDto(
                from.getId(),
                from.getPhotoPath()
        );
    }

}
