package com.kyb.sahabul.business.concretes;

import com.kyb.sahabul.business.abstracts.DistrictServices;
import com.kyb.sahabul.core.converter.DistrictDtoConverter;
import com.kyb.sahabul.dataAccess.abstracts.DistrictDao;
import com.kyb.sahabul.entities.concretes.District;
import com.kyb.sahabul.entities.dto.DistrictDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DistrictManager implements DistrictServices {
    private final DistrictDao districtDao;
    private final DistrictDtoConverter districtDtoConverter;

    public DistrictManager(DistrictDao districtDao,
                           DistrictDtoConverter districtDtoConverter) {
        this.districtDao = districtDao;
        this.districtDtoConverter = districtDtoConverter;
    }

    @Override
    public List<DistrictDto> getAll() {
        return districtDao.findAll().stream().map(districtDtoConverter::convert).collect(Collectors.toList());
    }

    @Override
    public District findById(int id) {
        return districtDao.getOne(id);
    }

    @Override
    public DistrictDto getById(int id) {
        return districtDtoConverter.convert(districtDao.getOne(id));
    }

}
