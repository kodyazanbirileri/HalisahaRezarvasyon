package com.kyb.sahabul.business.abstracts;

import com.kyb.sahabul.entities.concretes.District;
import com.kyb.sahabul.entities.dto.DistrictDto;
import com.kyb.sahabul.entities.dto.OnlyIdDto;

import java.util.List;

public interface DistrictServices {
    List<DistrictDto> getAll();
    District findById(int id);
    DistrictDto getById(int id);
    List<DistrictDto> getByCityId(OnlyIdDto from);
}
