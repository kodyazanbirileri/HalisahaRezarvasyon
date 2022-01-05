package com.kyb.sahabul.dataAccess.abstracts;

import com.kyb.sahabul.entities.concretes.District;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DistrictDao extends JpaRepository<District, Integer> {

    List<District> getAllByCityId(int id);

}
