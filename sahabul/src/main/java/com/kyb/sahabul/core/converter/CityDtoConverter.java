package com.kyb.sahabul.core.converter;

import com.kyb.sahabul.entities.concretes.City;
import com.kyb.sahabul.entities.dto.CityDto;
import org.springframework.stereotype.Component;

@Component
public class CityDtoConverter {

    public CityDto convert(City from)
    {
        return new CityDto(
                from.getId(),
                from.getCityName()
        );

    }



}
