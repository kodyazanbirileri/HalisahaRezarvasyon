package com.kyb.sahabul.business.abstracts;

import com.kyb.sahabul.entities.concretes.Property;
import com.kyb.sahabul.entities.dto.PropertyDto;

import java.util.List;

public interface PropertyServices {
    List<PropertyDto> getAll();
    Property findById(int id);
    PropertyDto getById(int id);
    PropertyDto add(Property property);
    void delete(Property property);
}
