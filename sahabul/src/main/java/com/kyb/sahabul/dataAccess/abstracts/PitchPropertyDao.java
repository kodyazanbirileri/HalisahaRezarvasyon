package com.kyb.sahabul.dataAccess.abstracts;

import com.kyb.sahabul.entities.concretes.PitchProperty;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PitchPropertyDao extends JpaRepository<PitchProperty, Integer> {
}
