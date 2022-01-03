package com.kyb.sahabul.business.abstracts;

import com.kyb.sahabul.entities.concretes.City;
import com.kyb.sahabul.entities.dto.CityDto;

import java.util.List;

public interface CityServices {
    List<CityDto> getAll();
    CityDto getById(int id);
    City findById(int id);
    CityDto add(City city);
    void delete(City city);
}
