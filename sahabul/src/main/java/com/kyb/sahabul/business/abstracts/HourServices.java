package com.kyb.sahabul.business.abstracts;

import com.kyb.sahabul.entities.concretes.Hour;
import com.kyb.sahabul.entities.dto.HourDto;

import java.util.List;

public interface HourServices {
    Hour findById(int id);
    List<HourDto> getAll();
}
