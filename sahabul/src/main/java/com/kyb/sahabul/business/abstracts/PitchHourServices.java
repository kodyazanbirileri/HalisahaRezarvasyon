package com.kyb.sahabul.business.abstracts;

import com.kyb.sahabul.entities.concretes.PitchHour;
import com.kyb.sahabul.entities.dto.PitchHourDto;

import java.util.List;

public interface PitchHourServices {
    List<PitchHourDto> getAll();
    PitchHourDto getById(int id);
    PitchHourDto add(PitchHour pitchHour);
    void delete(PitchHour pitchHour);
}
