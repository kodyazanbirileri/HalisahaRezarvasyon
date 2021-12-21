package com.kyb.sahabul.core.converter;

import com.kyb.sahabul.entities.concretes.Owner;
import com.kyb.sahabul.entities.dto.OwnerDto;
import org.springframework.stereotype.Component;

@Component
public class OwnerDtoConverter {

    private final UserDtoConverter userDtoConverter;

    public OwnerDtoConverter(UserDtoConverter userDtoConverter) {
        this.userDtoConverter = userDtoConverter;
    }


    public OwnerDto convert(Owner from) {
        return new OwnerDto(
                from.getId(),
                from.isConfirmed(),
                userDtoConverter.convert(from.getUser())
        );
    }

}
