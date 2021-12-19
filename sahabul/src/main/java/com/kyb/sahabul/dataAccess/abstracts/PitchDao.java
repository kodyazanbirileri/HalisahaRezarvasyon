package com.kyb.sahabul.dataAccess.abstracts;

import com.kyb.sahabul.entities.concretes.Pitch;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PitchDao extends JpaRepository<Pitch, Integer> {
}
