package com.kyb.sahabul.business.concretes;

import com.kyb.sahabul.business.abstracts.DistrictServices;
import com.kyb.sahabul.dataAccess.abstracts.DistrictDao;
import com.kyb.sahabul.entities.concretes.District;
import com.kyb.sahabul.entities.dto.DistrictDto;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DistrictManager implements DistrictServices {
    private final DistrictDao districtDao;

    public DistrictManager(DistrictDao districtDao) {
        this.districtDao = districtDao;
    }

    @Override
    public List<DistrictDto> getAll() {
        return null;
    }

    @Override
    public DistrictDto getById(int id) {
        return null;
    }

    @Override
    public District findById(int id) {
        return districtDao.getOne(id);
    }

    @Override
    public DistrictDto add(District district) {
        return null;
    }

    @Override
    public void delete(District district) {

    }
}
