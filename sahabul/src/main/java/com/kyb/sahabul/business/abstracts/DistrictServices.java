package com.kyb.sahabul.business.abstracts;

import com.kyb.sahabul.entities.concretes.District;
import com.kyb.sahabul.entities.dto.DistrictDto;

import java.util.List;

public interface DistrictServices {
    List<DistrictDto> getAll();
    DistrictDto getById(int id);
    DistrictDto add(District district);
    void delete(District district);
}
