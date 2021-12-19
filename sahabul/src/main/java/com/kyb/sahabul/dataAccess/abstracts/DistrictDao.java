package com.kyb.sahabul.dataAccess.abstracts;

import com.kyb.sahabul.entities.concretes.District;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DistrictDao extends JpaRepository<District, Integer> {
}
