package com.kyb.sahabul.business.abstracts;

import com.kyb.sahabul.entities.concretes.Subscription;
import com.kyb.sahabul.entities.dto.SubscriptionDto;
import com.kyb.sahabul.entities.dto.createrequest.CreateSubscriptionRequest;

import java.util.List;

public interface SubscriptionServices {
    List<SubscriptionDto> getAll();
    SubscriptionDto getById(int id);
    SubscriptionDto add(CreateSubscriptionRequest createSubscriptionRequest);
    void delete(Subscription subscription);
}
