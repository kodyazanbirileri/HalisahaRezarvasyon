package com.kyb.sahabul.business.concretes;

import com.kyb.sahabul.business.abstracts.SubscriptionServices;
import com.kyb.sahabul.core.converter.SubscriptionDtoConverter;
import com.kyb.sahabul.dataAccess.abstracts.SubscriptionDao;
import com.kyb.sahabul.entities.concretes.Subscription;
import com.kyb.sahabul.entities.dto.SubscriptionDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SubscriptionManager implements SubscriptionServices {
    private final SubscriptionDao subscriptionDao;
    private final SubscriptionDtoConverter subscriptionDtoConverter;

    public SubscriptionManager(SubscriptionDao subscriptionDao, SubscriptionDtoConverter subscriptionDtoConverter) {
        this.subscriptionDao = subscriptionDao;
        this.subscriptionDtoConverter = subscriptionDtoConverter;
    }

    @Override
    public List<SubscriptionDto> getAll() {
        return subscriptionDao.findAll().stream()
                .map(subscriptionDtoConverter::convert)
                .collect(Collectors.toList());
    }

    @Override
    public SubscriptionDto getById(int id) {
        return subscriptionDtoConverter.convert(subscriptionDao.getOne(id));
    }


    @Override
    public SubscriptionDto add(Subscription subscription) {
        return subscriptionDtoConverter.convert(subscriptionDao.save(subscription));
    }

    @Override
    public void delete(Subscription subscription) {
        subscriptionDao.delete(subscription);
    }
}
