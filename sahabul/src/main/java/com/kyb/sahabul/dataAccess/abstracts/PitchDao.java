package com.kyb.sahabul.dataAccess.abstracts;

import com.kyb.sahabul.entities.concretes.Pitch;
import com.kyb.sahabul.entities.dto.PitchDto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PitchDao extends JpaRepository<Pitch, Integer> {

    List<Pitch> findAllByDistrictId(int id);
    List<Pitch> findAllByDistrictCityId(int id);

}
