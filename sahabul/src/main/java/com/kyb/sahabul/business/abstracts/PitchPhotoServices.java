package com.kyb.sahabul.business.abstracts;

import com.kyb.sahabul.entities.concretes.PitchPhoto;
import com.kyb.sahabul.entities.dto.DistrictDto;
import com.kyb.sahabul.entities.dto.PitchPhotoDto;
import com.kyb.sahabul.entities.dto.createrequest.CreatePitchPhotoRequest;

import java.util.List;

public interface PitchPhotoServices {
    List<PitchPhotoDto> getAll();
    PitchPhotoDto getById(int id);
    PitchPhotoDto add(CreatePitchPhotoRequest createPitchPhotoRequest);
    void delete(PitchPhoto pitchPhoto);
}
