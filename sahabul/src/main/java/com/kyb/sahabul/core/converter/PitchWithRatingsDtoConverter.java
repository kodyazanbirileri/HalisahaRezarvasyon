package com.kyb.sahabul.core.converter;

import com.kyb.sahabul.entities.concretes.Pitch;
import com.kyb.sahabul.entities.dto.PitchWithRatingsDto;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class PitchWithRatingsDtoConverter {

    private final CityDtoConverter cityDtoConverter;
    private final DistrictDtoConverter districtDtoConverter;
    private final PitchPropertyDtoConverter pitchPropertyDtoConverter;
    private final PitchHourDtoConverter pitchHourDtoConverter;
    private final PitchPhotoDtoConverter pitchPhotoDtoConverter;
    private final RatingDtoConverter ratingDtoConverter;

    public PitchWithRatingsDtoConverter(CityDtoConverter cityDtoConverter,
                                        DistrictDtoConverter districtDtoConverter,
                                        PitchPropertyDtoConverter pitchPropertyDtoConverter,
                                        PitchHourDtoConverter pitchHourDtoConverter,
                                        PitchPhotoDtoConverter pitchPhotoDtoConverter,
                                        RatingDtoConverter ratingDtoConverter) {
        this.cityDtoConverter = cityDtoConverter;
        this.districtDtoConverter = districtDtoConverter;
        this.pitchPropertyDtoConverter = pitchPropertyDtoConverter;
        this.pitchHourDtoConverter = pitchHourDtoConverter;
        this.pitchPhotoDtoConverter = pitchPhotoDtoConverter;
        this.ratingDtoConverter = ratingDtoConverter;
    }

    public PitchWithRatingsDto convert(Pitch from) {
        return new PitchWithRatingsDto(
                from.getId(),
                from.getPitchName(),
                from.getAddress(),
                from.getPitchNumber(),
                cityDtoConverter.convert(from.getCity()),
                districtDtoConverter.convertToDistrictForPicthDto(from.getDistrict()),
                from.getPitchProperties().stream()
                        .map(pitchPropertyDtoConverter::convertToPitchPropertyForPitchDto)
                        .collect(Collectors.toList()),
                from.getPitchHours().stream()
                        .map(pitchHourDtoConverter::convert)
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
