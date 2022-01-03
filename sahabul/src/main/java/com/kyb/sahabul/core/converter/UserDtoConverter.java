package com.kyb.sahabul.core.converter;

import com.kyb.sahabul.entities.concretes.User;
import com.kyb.sahabul.entities.dto.UserDto;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;


import java.util.stream.Collectors;

@Component
public class UserDtoConverter {

    private final ReservationDtoConverter reservationDtoConverter;

    public UserDtoConverter(@Lazy ReservationDtoConverter reservationDtoConverter) {
        this.reservationDtoConverter = reservationDtoConverter;
    }

    public UserDto convert(User from){
        return new UserDto(
                from.getId(),
                from.getFirstName(),
                from.getLastName(),
                from.getEmail(),
                from.getPhoneNumber(),
                from.getReservations().stream()
                        .map(reservationDtoConverter::convert)
                        .collect(Collectors.toList())

                );
    }


}
