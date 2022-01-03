package com.kyb.sahabul.business.concretes;

import com.kyb.sahabul.business.abstracts.PropertyServices;
import com.kyb.sahabul.core.converter.PropertyDtoConverter;
import com.kyb.sahabul.dataAccess.abstracts.PropertyDao;
import com.kyb.sahabul.entities.concretes.Property;
import com.kyb.sahabul.entities.dto.PropertyDto;
import com.kyb.sahabul.entities.dto.createrequest.CreatePropertyRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PropertyManager implements PropertyServices {

    private final PropertyDtoConverter propertyDtoConverter;
    private final PropertyDao propertyDao;

    public PropertyManager(PropertyDtoConverter propertyDtoConverter, PropertyDao propertyDao) {
        this.propertyDtoConverter = propertyDtoConverter;
        this.propertyDao = propertyDao;
    }

    @Override
    public List<PropertyDto> getAll() {
        return propertyDao.findAll().stream()
                .map(propertyDtoConverter::convert)
                .collect(Collectors.toList());
    }

    @Override
    public Property findById(int id) {
        return propertyDao.getOne(id);
    }

    @Override
    public PropertyDto getById(int id) {
        return propertyDtoConverter.convert(propertyDao.getOne(id));
    }

    @Override
    public PropertyDto add(CreatePropertyRequest from) {

        Property tempProperty = new Property();
        tempProperty.setPropertyName(from.getPropertyName());
        
        return propertyDtoConverter.convert(propertyDao.save(tempProperty));
    }

    @Override
    public void delete(Property property) {
        propertyDao.delete(property);
    }
}
