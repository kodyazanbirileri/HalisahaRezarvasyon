package com.kyb.sahabul.core.converter;

import com.kyb.sahabul.entities.concretes.SystemUser;
import com.kyb.sahabul.entities.dto.SystemUserDto;
import org.springframework.stereotype.Component;

@Component
public class SystemUserDtoConverter {

    private UserDtoConverter userDtoConverter;

    public SystemUserDtoConverter(UserDtoConverter userDtoConverter) {
        this.userDtoConverter = userDtoConverter;
    }

    public SystemUserDto convert(SystemUser from) {
        return new SystemUserDto(
                from.getId(),
                from.isAdmin(),
                userDtoConverter.convert(from.getUser())
        );
    }

}
