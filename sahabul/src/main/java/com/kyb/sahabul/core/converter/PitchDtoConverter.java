package com.kyb.sahabul.core.converter;

import com.kyb.sahabul.entities.concretes.Pitch;
import com.kyb.sahabul.entities.concretes.PitchPhoto;
import com.kyb.sahabul.entities.concretes.PitchProperty;
import com.kyb.sahabul.entities.dto.PitchDto;
import com.kyb.sahabul.entities.dto.PitchPropertyDto;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class PitchDtoConverter {
    
    private final ReservationForPitchDtoConverter reservationForPitchDtoConverter;

    public PitchDtoConverter(PitchPropertyForPitchDtoConverter pitchPropertyForPitchDtoConverter,
                             ReservationForPitchDtoConverter reservationForPitchDtoConverter,
                             PitchPhotoDtoConverter pitchPhotoDtoConverter) {
        this.reservationForPitchDtoConverter = reservationForPitchDtoConverter;
    }


    public PitchDto convert(Pitch from) {
        return new PitchDto(
                from.getId(),
                from.getPitchName(),
                from.getAddress(),
                from.getPitchNumber(),
                from.getDistrict().getCity().getCityName(),
                from.getDistrict().getDistrictName(),
                from.isStatus(),
                Optional.ofNullable(from.getPitchProperties())
                        .orElseGet(Collections::emptyList)
                        .stream()
                        .map(p -> p.getProperty().getPropertyName())
                        .collect(Collectors.toList()),
                Optional.ofNullable(from.getPitchPhotos())
                        .orElseGet(Collections::emptyList)
                        .stream()
                        .map(PitchPhoto::getPhotoPath)
                        .collect(Collectors.toList()),
                Optional.ofNullable(from.getReservations())
                        .orElseGet(Collections::emptyList)
                        .stream()
                        .map(reservationForPitchDtoConverter::convert)
                        .collect(Collectors.toList())
        );
    }
}
