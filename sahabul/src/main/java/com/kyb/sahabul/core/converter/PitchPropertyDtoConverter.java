package com.kyb.sahabul.core.converter;

import com.kyb.sahabul.entities.concretes.PitchProperty;
import com.kyb.sahabul.entities.dto.PitchPropertyDto;
import com.kyb.sahabul.entities.dto.PitchPropertyForPitchDto;
import org.springframework.stereotype.Component;

@Component
public class PitchPropertyDtoConverter {


    public PitchPropertyDto convert(PitchProperty from){
        return new PitchPropertyDto(from.getId(),
                from.getId(),
                from.getProperty().getPropertyName()
                );
    }


}
