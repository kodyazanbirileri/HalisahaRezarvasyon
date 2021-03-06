package com.kyb.sahabul.core.converter;

import com.kyb.sahabul.entities.concretes.District;
import com.kyb.sahabul.entities.dto.CityDto;
import com.kyb.sahabul.entities.dto.DistrictDto;
import com.kyb.sahabul.entities.dto.DistrictForPitchDto;
import org.springframework.stereotype.Component;

@Component
public class DistrictDtoConverter {

    public DistrictDto convert(District from)
    {
        return new DistrictDto(
                from.getId(),
                from.getDistrictName(),
                from.getCity().getCityName()
        );
    }


}
