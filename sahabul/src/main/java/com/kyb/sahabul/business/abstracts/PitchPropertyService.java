package com.kyb.sahabul.business.abstracts;

import com.kyb.sahabul.dataAccess.abstracts.PitchPropertyDao;
import com.kyb.sahabul.entities.concretes.PitchProperty;
import com.kyb.sahabul.entities.dto.PitchDto;
import com.kyb.sahabul.entities.dto.PitchPropertyDto;
import com.kyb.sahabul.entities.dto.createrequest.CreatePitchPropertyRequest;

import java.util.List;

public interface PitchPropertyService {
    List<PitchPropertyDto> getAll();
    PitchPropertyDto getById(int id);
    PitchPropertyDto add(CreatePitchPropertyRequest createPitchPropertyRequest);
    void delete(PitchProperty pitchProperty);
}
