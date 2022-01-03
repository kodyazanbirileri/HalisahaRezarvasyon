package com.kyb.sahabul.business.concretes;

import com.kyb.sahabul.business.abstracts.PitchServices;
import com.kyb.sahabul.core.converter.PitchDtoConverter;
import com.kyb.sahabul.dataAccess.abstracts.PitchDao;
import com.kyb.sahabul.entities.concretes.Pitch;
import com.kyb.sahabul.entities.dto.PitchDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PitchManager implements PitchServices {

    private final PitchDao pitchDao;
    private final PitchDtoConverter pitchDtoConverter;

    public PitchManager(PitchDao pitchDao, PitchDtoConverter pitchDtoConverter) {
        this.pitchDao = pitchDao;
        this.pitchDtoConverter = pitchDtoConverter;
    }

    @Override
    public List<PitchDto> getAll() {
        return pitchDao.findAll().stream()
                .map(pitchDtoConverter::convert)
                .collect(Collectors.toList());
    }

    @Override
    public PitchDto getById(int id) {
        return pitchDtoConverter.convert(pitchDao.getOne(id));
    }

    @Override
    public PitchDto add(Pitch pitch) {
        return pitchDtoConverter.convert(pitchDao.save(pitch));
    }

    @Override
    public void delete(Pitch pitch) {
        pitchDao.delete(pitch);
    }
}
