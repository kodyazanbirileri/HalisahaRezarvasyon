package com.kyb.sahabul.dataAccess.abstracts;

import com.kyb.sahabul.entities.concretes.Hour;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HourDao extends JpaRepository<Hour, Integer> {
}
