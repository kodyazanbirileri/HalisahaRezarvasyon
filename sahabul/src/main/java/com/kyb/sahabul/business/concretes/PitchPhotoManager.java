package com.kyb.sahabul.business.concretes;

import com.kyb.sahabul.business.abstracts.PitchPhotoServices;
import com.kyb.sahabul.business.abstracts.PitchServices;
import com.kyb.sahabul.core.converter.PitchPhotoDtoConverter;
import com.kyb.sahabul.dataAccess.abstracts.PitchPhotoDao;
import com.kyb.sahabul.entities.concretes.PitchPhoto;
import com.kyb.sahabul.entities.dto.PitchPhotoDto;
import com.kyb.sahabul.entities.dto.createrequest.CreatePitchPhotoRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Service
public class PitchPhotoManager implements PitchPhotoServices {
    private final PitchPhotoDao pitchPhotoDao;
    private final PitchPhotoDtoConverter pitchPhotoDtoConverter;
    private final PitchServices pitchServices;

    public PitchPhotoManager(PitchPhotoDao pitchPhotoDao,
                             PitchPhotoDtoConverter pitchPhotoDtoConverter,
                             PitchServices pitchServices) {
        this.pitchPhotoDao = pitchPhotoDao;
        this.pitchPhotoDtoConverter = pitchPhotoDtoConverter;
        this.pitchServices = pitchServices;
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
    public PitchPhotoDto add(CreatePitchPhotoRequest from) {

        PitchPhoto tempPitchPhoto = new PitchPhoto();
        tempPitchPhoto.setPhotoPath(from.getPhotoPath());
        tempPitchPhoto.setPitch(pitchServices.findById(from.getPitchId()));

        return pitchPhotoDtoConverter.convert(pitchPhotoDao.save(tempPitchPhoto));
    }

    @Override
    public void delete(PitchPhoto pitchPhoto) {
        pitchPhotoDao.delete(pitchPhoto);
    }
}
