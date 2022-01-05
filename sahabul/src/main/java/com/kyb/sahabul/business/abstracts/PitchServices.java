package com.kyb.sahabul.business.abstracts;

import com.kyb.sahabul.entities.concretes.Pitch;
import com.kyb.sahabul.entities.dto.OnlyIdDto;
import com.kyb.sahabul.entities.dto.PitchDto;
import com.kyb.sahabul.entities.dto.createrequest.CreatePitchRequest;

import java.util.List;

public interface PitchServices {
    List<PitchDto> getAll();
    List<PitchDto> getByCityId(OnlyIdDto onlyIdDto);
    List<PitchDto> getByDistrictId(OnlyIdDto onlyIdDto);
    Pitch findById(int id);
    PitchDto getById(int id);
    PitchDto add(CreatePitchRequest from);
    PitchDto delete(int pitchId);

}
