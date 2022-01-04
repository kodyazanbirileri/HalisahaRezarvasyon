package com.kyb.sahabul.core.converter;

import com.kyb.sahabul.entities.concretes.Pitch;
import com.kyb.sahabul.entities.dto.PitchDto;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Collections;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class PitchDtoConverter {

    private final CityDtoConverter cityDtoConverter;
    private final DistrictDtoConverter districtDtoConverter;
    private final PitchPropertyDtoConverter pitchPropertyDtoConverter;
    private final ReservationDtoConverter reservationDtoConverter;
    private final PitchPhotoDtoConverter pitchPhotoDtoConverter;

    public PitchDtoConverter(CityDtoConverter cityDtoConverter,
                             DistrictDtoConverter districtDtoConverter,
                            @Lazy PitchPropertyDtoConverter pitchPropertyDtoConverter,
                            @Lazy ReservationDtoConverter reservationDtoConverter,
                             PitchPhotoDtoConverter pitchPhotoDtoConverter) {
        this.cityDtoConverter = cityDtoConverter;
        this.districtDtoConverter = districtDtoConverter;
        this.pitchPropertyDtoConverter = pitchPropertyDtoConverter;
        this.reservationDtoConverter = reservationDtoConverter;
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
                Optional.ofNullable(from.getPitchProperties())
                        .orElseGet(Collections::emptyList)
                        .stream()
                        .map(pitchPropertyDtoConverter::convertToPitchPropertyForPitchDto)
                        .collect(Collectors.toList()),
                Optional.ofNullable(from.getReservations())
                        .orElseGet(Collections::emptyList)
                        .stream()
                        .map(reservationDtoConverter::convert)
                        .collect(Collectors.toList()),
                Optional.ofNullable(from.getPitchPhotos())
                        .orElseGet(Collections::emptyList)
                        .stream()
                        .map(pitchPhotoDtoConverter::convert)
                        .collect(Collectors.toList())
        );
    }
}
