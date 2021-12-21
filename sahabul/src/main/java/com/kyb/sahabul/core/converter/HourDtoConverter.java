package com.kyb.sahabul.core.converter;

import com.kyb.sahabul.entities.concretes.Hour;
import com.kyb.sahabul.entities.dto.HourDto;
import org.springframework.stereotype.Component;

@Component
public class HourDtoConverter {

    public HourDto convert(Hour from)
    {
        return new HourDto(
                from.getId(),
                from.getStartHour(),
                from.getEndHour()
        );
    }

}
