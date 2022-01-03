package com.kyb.sahabul.business.concretes;

import com.kyb.sahabul.business.abstracts.PitchPhotoServices;
import com.kyb.sahabul.core.converter.PitchPhotoDtoConverter;
import com.kyb.sahabul.dataAccess.abstracts.PitchPhotoDao;
import com.kyb.sahabul.entities.concretes.PitchPhoto;
import com.kyb.sahabul.entities.dto.PitchPhotoDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Service
public class PitchPhotoManager implements PitchPhotoServices {
    private final PitchPhotoDao pitchPhotoDao;
    private final PitchPhotoDtoConverter pitchPhotoDtoConverter;

    public PitchPhotoManager(PitchPhotoDao pitchPhotoDao, PitchPhotoDtoConverter pitchPhotoDtoConverter) {
        this.pitchPhotoDao = pitchPhotoDao;
        this.pitchPhotoDtoConverter = pitchPhotoDtoConverter;
    }

    @Override
    public List<PitchPhotoDto> getAll() {
        return pitchPhotoDao.findAll().stream()
                .map(pitchPhotoDtoConverter::convert)
                .collect(Collectors.toList());
    }

    @Override
    public PitchPhotoDto getById(int id) {
        return pitchPhotoDtoConverter.convert(pitchPhotoDao.getOne(id));
    }

    @Override
    public PitchPhotoDto add(PitchPhoto pitchPhoto) {
        return pitchPhotoDtoConverter.convert(pitchPhotoDao.save(pitchPhoto));
    }

    @Override
    public void delete(PitchPhoto pitchPhoto) {
        pitchPhotoDao.delete(pitchPhoto);
    }
}
