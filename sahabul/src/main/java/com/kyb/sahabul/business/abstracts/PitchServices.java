package com.kyb.sahabul.business.abstracts;

import com.kyb.sahabul.entities.concretes.Pitch;
import com.kyb.sahabul.entities.dto.PitchDto;
import com.kyb.sahabul.entities.dto.createrequest.CreatePitchRequest;

import java.util.List;

public interface PitchServices {
    List<PitchDto> getAll();
    List<PitchDto> getByCityId(int id);
    List<PitchDto> getByDistrictId(int id);
    Pitch findById(int id);
    PitchDto getById(int id);
    PitchDto add(CreatePitchRequest from);
    PitchDto delete(int pitchId);

}
