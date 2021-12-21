package com.kyb.sahabul.core.converter;

import com.kyb.sahabul.entities.concretes.User;
import com.kyb.sahabul.entities.dto.UserDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserDtoConverter {

    private final ReservationDtoConverter reservationDtoConverter;

    public UserDtoConverter(ReservationDtoConverter reservationDtoConverter) {
        this.reservationDtoConverter = reservationDtoConverter;
    }

    UserDto convert(User from){
        return new UserDto(
                from.getId(),
                from.getPassword(),
                from.getEmail(),
                from.getUserCreated(),
                from.isStatus(),
                from.getPhoneNumber(),
                from.getReservations().stream()
                        .map(reservationDtoConverter::convert)
                        .collect(Collectors.toList())

                );
    }


}
