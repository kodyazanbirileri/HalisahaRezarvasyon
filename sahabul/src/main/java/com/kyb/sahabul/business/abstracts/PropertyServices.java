package com.kyb.sahabul.business.abstracts;

import com.kyb.sahabul.entities.concretes.Property;
import com.kyb.sahabul.entities.dto.PropertyDto;
import com.kyb.sahabul.entities.dto.createrequest.CreatePropertyRequest;

import java.util.List;

public interface PropertyServices {
    List<PropertyDto> getAll();
    Property findById(int id);
    PropertyDto getById(int id);
    PropertyDto add(CreatePropertyRequest from);
    void delete(Property property);
}
