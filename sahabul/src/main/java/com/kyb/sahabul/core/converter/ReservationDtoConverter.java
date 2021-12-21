package com.kyb.sahabul.core.converter;


import com.kyb.sahabul.entities.concretes.Reservation;
import com.kyb.sahabul.entities.dto.ReservationDto;
import org.springframework.stereotype.Component;



@Component
public class ReservationDtoConverter {
    private final HourDtoConverter hourDtoConverter;
    private final PitchDtoConverter pitchDtoConverter;
    private final UserDtoConverter userDtoConverter;

    public ReservationDtoConverter(HourDtoConverter hourDtoConverter,
                                   PitchDtoConverter pitchDtoConverter,
                                   UserDtoConverter userDtoConverter) {
        this.hourDtoConverter = hourDtoConverter;
        this.pitchDtoConverter = pitchDtoConverter;
        this.userDtoConverter = userDtoConverter;
    }

    public ReservationDto convert(Reservation from)
    {
        return new ReservationDto(from.getId(),
                from.getReservationDate(),
                from.getNote(),
                from.isStatus(),
                hourDtoConverter.convert(from.getReservationHour()),
                pitchDtoConverter.convert(from.getPitch()),
                userDtoConverter.convert(from.getUser())
                );
    }



}
