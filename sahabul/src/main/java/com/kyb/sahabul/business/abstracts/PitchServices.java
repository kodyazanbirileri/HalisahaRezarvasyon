package com.kyb.sahabul.business.abstracts;

import com.kyb.sahabul.entities.concretes.Pitch;
import com.kyb.sahabul.entities.dto.PitchDto;

import java.util.List;

public interface PitchServices {
    List<PitchDto> getAll();
    PitchDto getById(int id);
    Pitch findById(int id);
    PitchDto add(Pitch pitch);
    void delete(Pitch pitch);

}
