package com.kyb.sahabul.business.abstracts;

import com.kyb.sahabul.entities.concretes.District;
import com.kyb.sahabul.entities.dto.DistrictDto;

import java.util.List;

public interface DistrictServices {
    List<DistrictDto> getAll();
    District findById(int id);
    DistrictDto getById(int id);
}
