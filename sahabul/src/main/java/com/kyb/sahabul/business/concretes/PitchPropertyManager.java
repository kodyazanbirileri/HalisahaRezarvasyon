package com.kyb.sahabul.business.concretes;

import com.kyb.sahabul.business.abstracts.PitchPropertyService;
import com.kyb.sahabul.core.converter.PitchDtoConverter;
import com.kyb.sahabul.core.converter.PitchPropertyDtoConverter;
import com.kyb.sahabul.dataAccess.abstracts.PitchPropertyDao;
import com.kyb.sahabul.entities.concretes.PitchProperty;
import com.kyb.sahabul.entities.dto.PitchPropertyDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PitchPropertyManager implements PitchPropertyService {
    private final PitchPropertyDao pitchPropertyDao;
    private final PitchPropertyDtoConverter pitchPropertyDtoConverter;

    public PitchPropertyManager(PitchPropertyDao pitchPropertyDao, PitchPropertyDtoConverter pitchPropertyDtoConverter) {
        this.pitchPropertyDao = pitchPropertyDao;
        this.pitchPropertyDtoConverter = pitchPropertyDtoConverter;
    }

    @Override
    public List<PitchPropertyDto> getAll() {
        return pitchPropertyDao.findAll().stream()
                .map(pitchPropertyDtoConverter::convert)
                .collect(Collectors.toList());
    }

    @Override
    public PitchPropertyDto getById(int id) {
        return pitchPropertyDtoConverter.convert(pitchPropertyDao.getOne(id));
    }

    @Override
    public PitchPropertyDto add(PitchProperty pitchProperty) {
        return pitchPropertyDtoConverter.convert(pitchPropertyDao.save(pitchProperty));
    }

    @Override
    public void delete(PitchProperty pitchProperty) {
        pitchPropertyDao.delete(pitchProperty);

    }
}
