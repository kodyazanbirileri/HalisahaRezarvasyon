package com.kyb.sahabul.core.converter;


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



}
