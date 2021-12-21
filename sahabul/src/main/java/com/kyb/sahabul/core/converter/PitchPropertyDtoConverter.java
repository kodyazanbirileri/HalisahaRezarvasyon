package com.kyb.sahabul.core.converter;

import com.kyb.sahabul.entities.concretes.PitchProperty;
import com.kyb.sahabul.entities.dto.PitchPropertyForPitchDto;
import org.springframework.stereotype.Component;

@Component
public class PitchPropertyDtoConverter {

    private final PropertyDtoConverter propertyDtoConverter;

    public PitchPropertyDtoConverter(PropertyDtoConverter propertyDtoConverter) {
        this.propertyDtoConverter = propertyDtoConverter;
    }

    public PitchPropertyForPitchDto convertToPitchPropertyForPitchDto(PitchProperty from)
    {
        return new PitchPropertyForPitchDto(
                from.getId(),
                propertyDtoConverter.convert(from.getProperty())

        );
    }

}
