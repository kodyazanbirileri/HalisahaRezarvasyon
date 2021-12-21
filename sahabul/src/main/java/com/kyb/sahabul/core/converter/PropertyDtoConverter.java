package com.kyb.sahabul.core.converter;

import com.kyb.sahabul.entities.concretes.Property;
import com.kyb.sahabul.entities.dto.PropertyDto;
import org.springframework.stereotype.Component;

@Component
public class PropertyDtoConverter {

    public PropertyDto convert(Property from)
    {
        return new PropertyDto(
                from.getId(),
                from.getPropertyName()
        );
    }

}
