package com.kyb.sahabul.core.converter;

import com.kyb.sahabul.entities.concretes.Pitch;
import com.kyb.sahabul.entities.dto.PitchDto;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class PitchDtoConverter {


    private final PitchPropertyForPitchDtoConverter pitchPropertyForPitchDtoConverter;
    private final ReservationForPitchDtoConverter reservationForPitchDtoConverter;
    private final PitchPhotoDtoConverter pitchPhotoDtoConverter;

    @Lazy
    public PitchDtoConverter(PitchPropertyForPitchDtoConverter pitchPropertyForPitchDtoConverter,
                             ReservationForPitchDtoConverter reservationForPitchDtoConverter,
                             PitchPhotoDtoConverter pitchPhotoDtoConverter) {
        this.pitchPropertyForPitchDtoConverter = pitchPropertyForPitchDtoConverter;
        this.reservationForPitchDtoConverter = reservationForPitchDtoConverter;
        this.pitchPhotoDtoConverter = pitchPhotoDtoConverter;
    }


    public PitchDto convert(Pitch from) {
        return new PitchDto(
                from.getId(),
                from.getPitchName(),
                from.getAddress(),
                from.getPitchNumber(),
                from.getDistrict().getCity().getCityName(),
                from.getDistrict().getDistrictName(),
                Optional.ofNullable(from.getPitchProperties())
                        .orElseGet(Collections::emptyList)
                        .stream()
                        .map(pitchPropertyForPitchDtoConverter::convert)
                        .collect(Collectors.toList()),
                Optional.ofNullable(from.getReservations())
                        .orElseGet(Collections::emptyList)
                        .stream()
                        .map(reservationForPitchDtoConverter::convert)
                        .collect(Collectors.toList()),
                Optional.ofNullable(from.getPitchPhotos())
                        .orElseGet(Collections::emptyList)
                        .stream()
                        .map(pitchPhotoDtoConverter::convert)
                        .collect(Collectors.toList())
        );
    }
}
