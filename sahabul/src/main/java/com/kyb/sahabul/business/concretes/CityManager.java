package com.kyb.sahabul.business.concretes;

import com.kyb.sahabul.business.abstracts.CityServices;
import com.kyb.sahabul.core.converter.CityDtoConverter;
import com.kyb.sahabul.dataAccess.abstracts.CityDao;
import com.kyb.sahabul.entities.concretes.City;
import com.kyb.sahabul.entities.dto.CityDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CityManager implements CityServices {
    private final CityDao cityDao;
    private final CityDtoConverter cityDtoConverter;

    public CityManager(CityDao cityDao,
                       CityDtoConverter cityDtoConverter) {
        this.cityDao = cityDao;
        this.cityDtoConverter = cityDtoConverter;
    }

    @Override
    public List<CityDto> getAll() {
        return cityDao.findAll()
                .stream().map(cityDtoConverter::convert)
                .collect(Collectors.toList());
    }

    @Override
    public CityDto getById(int id) {
        return cityDtoConverter.convert(cityDao.getOne(id));
    }

    @Override
    public City findById(int id) {
        return cityDao.getOne(id);
    }



}
