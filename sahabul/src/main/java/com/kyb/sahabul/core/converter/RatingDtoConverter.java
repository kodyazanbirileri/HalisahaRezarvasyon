package com.kyb.sahabul.core.converter;

import com.kyb.sahabul.entities.concretes.Rating;
import com.kyb.sahabul.entities.dto.RatingDto;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class RatingDtoConverter {

    private final RatingPhotoDtoConverter ratingPhotoDtoConverter;


    public RatingDtoConverter(RatingPhotoDtoConverter ratingPhotoDtoConverter) {
        this.ratingPhotoDtoConverter = ratingPhotoDtoConverter;
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
                from.getReservation().getId()

        );

    }

}
