package com.kyb.sahabul.dataAccess.abstracts;

import com.kyb.sahabul.entities.concretes.PitchHour;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PitchHourDao extends JpaRepository<PitchHour, Integer> {
}
