package com.kyb.sahabul.core.converter;

import com.kyb.sahabul.entities.concretes.Subscription;
import com.kyb.sahabul.entities.dto.SubscriptionDto;
import org.springframework.stereotype.Component;

@Component
public class SubscriptionDtoConverter {

    private final ReservationDtoConverter reservationDtoConverter;

    public SubscriptionDtoConverter(ReservationDtoConverter reservationDtoConverter) {
        this.reservationDtoConverter = reservationDtoConverter;
    }


    public SubscriptionDto convert(Subscription from) {
        return new SubscriptionDto(
                from.getId(),
                from.isStatus(),
                reservationDtoConverter.convert(from.getReservation())
        );
    }

}
