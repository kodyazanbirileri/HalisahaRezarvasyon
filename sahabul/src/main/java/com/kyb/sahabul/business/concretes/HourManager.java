package com.kyb.sahabul.business.concretes;

import com.kyb.sahabul.business.abstracts.HourServices;
import com.kyb.sahabul.core.converter.HourDtoConverter;
import com.kyb.sahabul.dataAccess.abstracts.HourDao;
import com.kyb.sahabul.entities.concretes.Hour;
import com.kyb.sahabul.entities.dto.HourDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class HourManager implements HourServices {
    private final HourDao hourDao;
    private final HourDtoConverter hourDtoConverter;

    public HourManager(HourDao hourDao,
                       HourDtoConverter hourDtoConverter) {
        this.hourDao = hourDao;
        this.hourDtoConverter = hourDtoConverter;
    }


    @Override
    public Hour findById(int id) {
        return hourDao.getOne(id);
    }

    @Override
    public List<HourDto> getAll() {
        return hourDao.findAll().stream()
                .map(hourDtoConverter::convert).collect(Collectors.toList());
    }
}
