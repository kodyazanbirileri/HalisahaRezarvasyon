package com.kyb.sahabul.core.converter;

import com.kyb.sahabul.entities.concretes.User;
import com.kyb.sahabul.entities.dto.UserDto;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserDtoConverter {

    private final ReservationDtoConverter reservationDtoConverter;

    public UserDtoConverter(ReservationDtoConverter reservationDtoConverter) {
        this.reservationDtoConverter = reservationDtoConverter;
    }

    UserDto convert(User user){
        return new UserDto(user.getId(),
                user.getUserName(),
                user.getEmail(),
                user.getUserCreated(),
                user.isStatus(),
                )
    }


}
