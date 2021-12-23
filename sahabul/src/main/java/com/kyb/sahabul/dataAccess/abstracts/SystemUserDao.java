package com.kyb.sahabul.dataAccess.abstracts;

import com.kyb.sahabul.entities.concretes.Subscription;
import com.kyb.sahabul.entities.concretes.SystemUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SystemUserDao extends JpaRepository<SystemUser, Integer> {
}
