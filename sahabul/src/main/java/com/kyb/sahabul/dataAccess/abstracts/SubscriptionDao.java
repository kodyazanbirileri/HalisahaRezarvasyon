package com.kyb.sahabul.dataAccess.abstracts;

import com.kyb.sahabul.entities.concretes.Subscription;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubscriptionDao extends JpaRepository<Subscription, Integer> {

}
