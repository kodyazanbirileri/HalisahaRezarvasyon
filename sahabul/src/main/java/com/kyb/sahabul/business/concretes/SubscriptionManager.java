package com.kyb.sahabul.business.concretes;

import com.kyb.sahabul.business.abstracts.ReservationServices;
import com.kyb.sahabul.business.abstracts.SubscriptionServices;
import com.kyb.sahabul.core.converter.SubscriptionDtoConverter;
import com.kyb.sahabul.dataAccess.abstracts.SubscriptionDao;
import com.kyb.sahabul.entities.concretes.Subscription;
import com.kyb.sahabul.entities.dto.SubscriptionDto;
import com.kyb.sahabul.entities.dto.createrequest.CreateSubscriptionRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SubscriptionManager implements SubscriptionServices {
    private final SubscriptionDao subscriptionDao;
    private final SubscriptionDtoConverter subscriptionDtoConverter;
    private final ReservationServices reservationServices;

    public SubscriptionManager(SubscriptionDao subscriptionDao, SubscriptionDtoConverter subscriptionDtoConverter, ReservationServices reservationServices) {
        this.subscriptionDao = subscriptionDao;
        this.subscriptionDtoConverter = subscriptionDtoConverter;
        this.reservationServices = reservationServices;
    }

    @Override
    public List<SubscriptionDto> getAll() {
        return subscriptionDao.findAll().stream()
                .filter(Subscription::isStatus)
                .map(subscriptionDtoConverter::convert)
                .collect(Collectors.toList());
    }

    @Override
    public SubscriptionDto getById(int id) {
        Subscription tempSubscription = subscriptionDao.getOne(id);
        return tempSubscription.isStatus() ?
                subscriptionDtoConverter.convert(tempSubscription) :
                null;
    }


    @Override
    public SubscriptionDto add(CreateSubscriptionRequest from) {
        Subscription subscription = new Subscription();
        subscription.setReservation(reservationServices.findById(from.getReservationId()));

        return subscriptionDtoConverter.convert(subscriptionDao.save(subscription));
    }

    @Override
    public void delete(Subscription subscription) {
        subscriptionDao.delete(subscription);
    }
}
