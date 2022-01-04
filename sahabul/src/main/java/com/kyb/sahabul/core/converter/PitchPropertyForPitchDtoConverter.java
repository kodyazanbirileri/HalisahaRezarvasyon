package com.kyb.sahabul.core.converter;

import com.kyb.sahabul.entities.concretes.PitchProperty;
import com.kyb.sahabul.entities.dto.PitchPropertyForPitchDto;
import org.springframework.stereotype.Component;

@Component
public class PitchPropertyForPitchDtoConverter {

    public PitchPropertyForPitchDto convert(PitchProperty from)
    {
        return new PitchPropertyForPitchDto(
                from.getId(),
                from.getProperty().getPropertyName()

        );
    }
}
