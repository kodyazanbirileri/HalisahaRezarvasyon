package com.kyb.sahabul.business.concretes;

import com.kyb.sahabul.business.abstracts.PitchHourServices;
import com.kyb.sahabul.core.converter.PitchHourDtoConverter;
import com.kyb.sahabul.dataAccess.abstracts.PitchHourDao;
import com.kyb.sahabul.entities.concretes.PitchHour;
import com.kyb.sahabul.entities.dto.PitchHourDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Service
public class PitchHourManager implements PitchHourServices {
    private final PitchHourDao pitchHourDao;
    private final PitchHourDtoConverter pitchHourDtoConverter;


    public PitchHourManager(PitchHourDao pitchHourDao, PitchHourDtoConverter pitchHourDtoConverter) {
        this.pitchHourDao = pitchHourDao;
        this.pitchHourDtoConverter = pitchHourDtoConverter;
    }

    @Override
    public List<PitchHourDto> getAll() {
        return pitchHourDao.findAll().stream()
                .map(pitchHourDtoConverter::convert)
                .collect(Collectors.toList());
    }

    @Override
    public PitchHourDto getById(int id) {
        return pitchHourDtoConverter.convert(pitchHourDao.getOne(id));
    }

    @Override
    public PitchHourDto add(PitchHour pitchHour) {
        return pitchHourDtoConverter.convert(pitchHourDao.save(pitchHour));
    }

    @Override
    public void delete(PitchHour pitchHour) {
        pitchHourDao.delete(pitchHour);

    }
}
