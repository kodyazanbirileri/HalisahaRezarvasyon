package com.kyb.sahabul.core.converter;

import com.kyb.sahabul.entities.concretes.Rating;
import com.kyb.sahabul.entities.dto.RatingDto;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class RatingDtoConverter {

    private final RatingPhotoDtoConverter ratingPhotoDtoConverter;
    private final ReservationDtoConverter reservationDtoConverter;

    public RatingDtoConverter(RatingPhotoDtoConverter ratingPhotoDtoConverter
            , ReservationDtoConverter reservationDtoConverter) {
        this.ratingPhotoDtoConverter = ratingPhotoDtoConverter;
        this.reservationDtoConverter = reservationDtoConverter;
    }

    public RatingDto convert(Rating from) {

        return new RatingDto(
                from.getId(),
                from.getRate(),
                from.getRateDetail(),
                from.isStatus(),
                from.getRatingPhotos().stream()
                        .map(ratingPhotoDtoConverter::convert)
                        .collect(Collectors.toList()),
                reservationDtoConverter.convert(from.getReservation())

        );

    }

}
