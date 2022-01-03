package com.kyb.sahabul.business.concretes;

import com.kyb.sahabul.business.abstracts.PitchPropertyService;
import com.kyb.sahabul.business.abstracts.PitchServices;
import com.kyb.sahabul.business.abstracts.PropertyServices;
import com.kyb.sahabul.core.converter.PitchPropertyDtoConverter;
import com.kyb.sahabul.dataAccess.abstracts.PitchPropertyDao;
import com.kyb.sahabul.entities.concretes.PitchProperty;
import com.kyb.sahabul.entities.dto.PitchPropertyDto;
import com.kyb.sahabul.entities.dto.createrequest.CreatePitchPropertyRequest;
import com.kyb.sahabul.entities.dto.createrequest.CreatePitchRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PitchPropertyManager implements PitchPropertyService {
    private final PitchPropertyDao pitchPropertyDao;
    private final PitchPropertyDtoConverter pitchPropertyDtoConverter;
    private final PropertyServices propertyServices;
    private final PitchServices pitchServices;

    public PitchPropertyManager(PitchPropertyDao pitchPropertyDao,
                                PitchPropertyDtoConverter pitchPropertyDtoConverter,
                                PropertyServices propertyServices,
                                PitchServices pitchServices) {
        this.pitchPropertyDao = pitchPropertyDao;
        this.pitchPropertyDtoConverter = pitchPropertyDtoConverter;
        this.propertyServices = propertyServices;
        this.pitchServices = pitchServices;
    }

    @Override
    public List<PitchPropertyDto> getAll() {
        return pitchPropertyDao.findAll().stream()
                .map(pitchPropertyDtoConverter::convert)
                .collect(Collectors.toList());
    }

    @Override
    public PitchProperty findById(int id) {
        return pitchPropertyDao.getOne(id);
    }

    @Override
    public PitchPropertyDto getById(int id) {
        return pitchPropertyDtoConverter.convert(pitchPropertyDao.getOne(id));
    }

    @Override
    public PitchPropertyDto add(CreatePitchPropertyRequest from) {

        PitchProperty tempPitchProperty = new PitchProperty();
        tempPitchProperty.setProperty(propertyServices.findById(from.getPropertyId()));
        tempPitchProperty.setPitch(pitchServices.findById(from.getPitchId()));

        return pitchPropertyDtoConverter.convert(pitchPropertyDao.save(tempPitchProperty));
    }

    @Override
    public void delete(PitchProperty pitchProperty) {
        pitchPropertyDao.delete(pitchProperty);

    }
}
