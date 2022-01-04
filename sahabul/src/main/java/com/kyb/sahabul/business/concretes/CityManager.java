package com.kyb.sahabul.business.concretes;

import com.kyb.sahabul.business.abstracts.CityServices;
import com.kyb.sahabul.dataAccess.abstracts.CityDao;
import com.kyb.sahabul.entities.concretes.City;
import com.kyb.sahabul.entities.dto.CityDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityManager implements CityServices {
    private final CityDao cityDao;

    public CityManager(CityDao cityDao) {
        this.cityDao = cityDao;
    }

    @Override
    public List<CityDto> getAll() {
        return null;
    }

    @Override
    public CityDto getById(int id) {
        return null;
    }

    @Override
    public City findById(int id) {
        return cityDao.getOne(id);
    }


    @Override
    public CityDto add(City city) {
        return null;
    }

    @Override
    public void delete(City city) {

    }
}
