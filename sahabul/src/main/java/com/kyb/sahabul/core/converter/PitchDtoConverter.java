package com.kyb.sahabul.core.converter;

import com.kyb.sahabul.entities.concretes.Pitch;
import com.kyb.sahabul.entities.dto.PitchDto;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class PitchDtoConverter {

    private final CityDtoConverter cityDtoConverter;
    private final DistrictDtoConverter districtDtoConverter;
    private final PitchPropertyDtoConverter pitchPropertyDtoConverter;
    private final ReservationDtoConverter reservationDtoConverter;
    private final PitchHourDtoConverter pitchHourDtoConverter;
    private final PitchPhotoDtoConverter pitchPhotoDtoConverter;

    public PitchDtoConverter(CityDtoConverter cityDtoConverter,
                             DistrictDtoConverter districtDtoConverter,
                             PitchPropertyDtoConverter pitchPropertyDtoConverter,
                            @Lazy ReservationDtoConverter reservationDtoConverter,
                             PitchHourDtoConverter pitchHourDtoConverter,
                             PitchPhotoDtoConverter pitchPhotoDtoConverter) {
        this.cityDtoConverter = cityDtoConverter;
        this.districtDtoConverter = districtDtoConverter;
        this.pitchPropertyDtoConverter = pitchPropertyDtoConverter;
        this.reservationDtoConverter = reservationDtoConverter;
        this.pitchHourDtoConverter = pitchHourDtoConverter;
        this.pitchPhotoDtoConverter = pitchPhotoDtoConverter;
    }


    public PitchDto convert(Pitch from) {
        return new PitchDto(
                from.getId(),
                from.getPitchName(),
                from.getAddress(),
                from.getPitchNumber(),
                cityDtoConverter.convert(from.getCity()),
                districtDtoConverter.convertToDistrictForPicthDto(from.getDistrict()),
                from.getPitchProperties().stream()
                        .map(pitchPropertyDtoConverter::convertToPitchPropertyForPitchDto)
                        .collect(Collectors.toList()),
                from.getReservations().stream()
                        .map(reservationDtoConverter::convert)
                        .collect(Collectors.toList()),
                from.getPitchHours().stream()
                        .map(pitchHourDtoConverter::convert)
                        .collect(Collectors.toList()),
                from.getPitchPhotos().stream()
                        .map(pitchPhotoDtoConverter::convert)
                        .collect(Collectors.toList())
        );
    }
}
