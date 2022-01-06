package com.kyb.sahabul.core.converter;


import com.kyb.sahabul.entities.concretes.Reservation;
import com.kyb.sahabul.entities.dto.ReservationDto;
import org.springframework.stereotype.Component;



@Component
public class ReservationDtoConverter {
    private final HourDtoConverter hourDtoConverter;


    public ReservationDtoConverter(HourDtoConverter hourDtoConverter) {
        this.hourDtoConverter = hourDtoConverter;

    }

    public ReservationDto convert(Reservation from)
    {
        return new ReservationDto(from.getId(),
                from.getReservationDate(),
                from.getNote(),
                from.isStatus(),
                from.getPitch().getPitchName(),
                hourDtoConverter.convert(from.getReservationHour()),
                from.getPitch().getId(),
                from.getUser().getId()
                );
    }



}
