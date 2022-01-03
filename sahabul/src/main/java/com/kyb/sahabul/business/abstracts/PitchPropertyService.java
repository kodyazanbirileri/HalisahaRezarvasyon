package com.kyb.sahabul.business.abstracts;

import com.kyb.sahabul.entities.concretes.PitchProperty;
import com.kyb.sahabul.entities.dto.PitchPropertyDto;
import com.kyb.sahabul.entities.dto.createrequest.CreatePitchPropertyRequest;

import java.util.List;

public interface PitchPropertyService {
    List<PitchPropertyDto> getAll();
    PitchProperty findById(int id);
    PitchPropertyDto getById(int id);
    PitchPropertyDto add(CreatePitchPropertyRequest from);
    void delete(PitchProperty pitchProperty);
}
