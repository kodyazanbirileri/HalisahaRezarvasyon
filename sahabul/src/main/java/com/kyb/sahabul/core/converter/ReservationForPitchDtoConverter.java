package com.kyb.sahabul.core.converter;

import com.kyb.sahabul.entities.concretes.Reservation;
import com.kyb.sahabul.entities.dto.ReservationForPitchDto;
import org.springframework.stereotype.Component;

@Component
public class ReservationForPitchDtoConverter {

    private final HourDtoConverter hourDtoConverter;

    public ReservationForPitchDtoConverter(HourDtoConverter hourDtoConverter) {
        this.hourDtoConverter = hourDtoConverter;
    }


    public ReservationForPitchDto convert(Reservation from) {
        return new ReservationForPitchDto(
                from.getId(),
                from.getReservationDate(),
                from.getNote(),
                from.isStatus(),
                hourDtoConverter.convert(from.getReservationHour()),
                from.getUser().getFirstName(),
                from.getUser().getLastName()

        );
    }
}
