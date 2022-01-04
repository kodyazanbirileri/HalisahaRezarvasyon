package com.kyb.sahabul.core.converter;

import com.kyb.sahabul.entities.concretes.Pitch;
import com.kyb.sahabul.entities.dto.PitchWithRatingsDto;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class PitchWithRatingsDtoConverter {

    private final CityDtoConverter cityDtoConverter;
    private final DistrictDtoConverter districtDtoConverter;
    private final PitchPropertyForPitchDtoConverter pitchPropertyForPitchDtoConverter;
    private final PitchPhotoDtoConverter pitchPhotoDtoConverter;
    private final RatingDtoConverter ratingDtoConverter;

    public PitchWithRatingsDtoConverter(CityDtoConverter cityDtoConverter,
                                        DistrictDtoConverter districtDtoConverter,
                                        PitchPropertyForPitchDtoConverter pitchPropertyForPitchDtoConverter,
                                        PitchPhotoDtoConverter pitchPhotoDtoConverter,
                                        RatingDtoConverter ratingDtoConverter) {
        this.cityDtoConverter = cityDtoConverter;
        this.districtDtoConverter = districtDtoConverter;
        this.pitchPropertyForPitchDtoConverter = pitchPropertyForPitchDtoConverter;
        this.pitchPhotoDtoConverter = pitchPhotoDtoConverter;
        this.ratingDtoConverter = ratingDtoConverter;
    }

    public PitchWithRatingsDto convert(Pitch from) {
        return new PitchWithRatingsDto(
                from.getId(),
                from.getPitchName(),
                from.getAddress(),
                from.getPitchNumber(),
                from.getDistrict().getCity().getCityName(),
                from.getDistrict().getDistrictName(),
                from.getPitchProperties().stream()
                        .map(pitchPropertyForPitchDtoConverter::convert)
                        .collect(Collectors.toList()),
                from.getPitchPhotos().stream()
                        .map(pitchPhotoDtoConverter::convert)
                        .collect(Collectors.toList()),
                from.getReservations().stream()
                        .map(r -> ratingDtoConverter.convert(r.getRating()))
                        .collect(Collectors.toList())
        );
    }

}
