package com.kyb.sahabul.core.converter;

import com.kyb.sahabul.entities.concretes.PitchProperty;
import com.kyb.sahabul.entities.dto.PitchPropertyDto;
import com.kyb.sahabul.entities.dto.PitchPropertyForPitchDto;
import org.springframework.stereotype.Component;

@Component
public class PitchPropertyDtoConverter {

    private final PropertyDtoConverter propertyDtoConverter;
    private final PitchDtoConverter pitchDtoConverter;

    public PitchPropertyDtoConverter(PropertyDtoConverter propertyDtoConverter, PitchDtoConverter pitchDtoConverter) {
        this.propertyDtoConverter = propertyDtoConverter;
        this.pitchDtoConverter = pitchDtoConverter;
    }

    //*

    public PitchPropertyDto convert(PitchProperty from){
        return new PitchPropertyDto(from.getId(),
                pitchDtoConverter.convert(from.getPitch()),
                propertyDtoConverter.convert(from.getProperty())
                );
    }

    public PitchPropertyForPitchDto convertToPitchPropertyForPitchDto(PitchProperty from)
    {
        return new PitchPropertyForPitchDto(
                from.getId(),
                propertyDtoConverter.convert(from.getProperty())

        );
    }

}
