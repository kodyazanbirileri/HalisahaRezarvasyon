package com.kyb.sahabul.core.converter;

import com.kyb.sahabul.entities.concretes.PitchHour;
import com.kyb.sahabul.entities.dto.PitchHourDto;
import org.springframework.stereotype.Component;

@Component
public class PitchHourDtoConverter {

    private final HourDtoConverter hourDtoConverter;

    public PitchHourDtoConverter(HourDtoConverter hourDtoConverter) {
        this.hourDtoConverter = hourDtoConverter;
    }


    public PitchHourDto convert(PitchHour from) {
        return new PitchHourDto(
                from.getId(),
                hourDtoConverter.convert(from.getHour())
        );
    }
}
