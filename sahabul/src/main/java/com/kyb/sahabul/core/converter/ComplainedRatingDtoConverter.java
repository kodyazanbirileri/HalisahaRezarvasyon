package com.kyb.sahabul.core.converter;

import com.kyb.sahabul.entities.concretes.ComplainedRating;
import com.kyb.sahabul.entities.dto.ComplainedRatingDto;
import org.springframework.stereotype.Component;

@Component
public class ComplainedRatingDtoConverter {

    private final ReservationDtoConverter reservationDtoConverter;

    public ComplainedRatingDtoConverter(ReservationDtoConverter reservationDtoConverter) {
        this.reservationDtoConverter = reservationDtoConverter;
    }

    public ComplainedRatingDto convert(ComplainedRating from) {
        return new ComplainedRatingDto(
                from.getId(),
                from.isConfirmed(),
                reservationDtoConverter.convert(from.getReservation())
        );
    }

}
