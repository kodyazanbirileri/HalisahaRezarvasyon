package com.kyb.sahabul.business.abstracts;

import com.kyb.sahabul.entities.concretes.Subscription;
import com.kyb.sahabul.entities.dto.SubscriptionDto;

import java.util.List;

public interface SubscriptionServices {
    List<SubscriptionDto> getAll();
    SubscriptionDto getById(int id);
    SubscriptionDto add(Subscription subscription);
    void delete(Subscription subscription);
}
