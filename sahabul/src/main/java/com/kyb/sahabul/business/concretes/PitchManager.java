package com.kyb.sahabul.business.concretes;

import com.kyb.sahabul.business.abstracts.*;
import com.kyb.sahabul.core.converter.PitchDtoConverter;
import com.kyb.sahabul.dataAccess.abstracts.PitchDao;
import com.kyb.sahabul.entities.concretes.Pitch;
import com.kyb.sahabul.entities.dto.OnlyIdDto;
import com.kyb.sahabul.entities.dto.PitchDto;
import com.kyb.sahabul.entities.dto.createrequest.CreatePitchPhotoRequest;
import com.kyb.sahabul.entities.dto.createrequest.CreatePitchPropertyRequest;
import com.kyb.sahabul.entities.dto.createrequest.CreatePitchRequest;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PitchManager implements PitchServices {

    private final PitchDao pitchDao;
    private final PitchDtoConverter pitchDtoConverter;
    private final PitchPropertyService pitchPropertyService;
    private final PitchPhotoServices pitchPhotoServices;
    private final DistrictServices districtServices;

    @Lazy
    public PitchManager(PitchDao pitchDao,
                        PitchDtoConverter pitchDtoConverter,
                        PitchPropertyService pitchPropertyService,
                        PitchPhotoServices pitchPhotoServices,
                        DistrictServices districtServices) {
        this.pitchDao = pitchDao;
        this.pitchDtoConverter = pitchDtoConverter;
        this.pitchPropertyService = pitchPropertyService;
        this.pitchPhotoServices = pitchPhotoServices;
        this.districtServices = districtServices;
    }

    @Override
    public List<PitchDto> getAll() {
        return pitchDao.findAll().stream()
                .map(pitchDtoConverter::convert)
                .collect(Collectors.toList());
    }

    @Override
    public List<PitchDto> getByCityId(OnlyIdDto from) {
        return pitchDao.findAllByDistrictCityId(from.getId())
                .stream().map(pitchDtoConverter::convert)
                .collect(Collectors.toList());
    }

    @Override
    public List<PitchDto> getByDistrictId(OnlyIdDto from) {
        return pitchDao.findAllByDistrictId(from.getId())
                .stream().map(pitchDtoConverter::convert)
                .collect(Collectors.toList());
    }

    @Override
    public Pitch findById(int id) {
        return pitchDao.getOne(id);
    }


    @Override
    public PitchDto getById(int id) {
        return pitchDtoConverter.convert(pitchDao.getOne(id));
    }

    @Override
    public PitchDto add(CreatePitchRequest from) {

        Pitch tempPitch = new Pitch();
        tempPitch.setPitchName(from.getPitchName());
        tempPitch.setAddress(from.getAddress());
        tempPitch.setPitchNumber(from.getPitchNumber());
        tempPitch.setDistrict(districtServices.findById(from.getDistrictId()));

        int pitchId = pitchDao.save(tempPitch).getId();

        from.getPitchPhotoRequests().forEach(pp -> {
            pitchPhotoServices.add(new CreatePitchPhotoRequest(pitchId,pp.getPhotoPath()));
        });

        from.getPitchPropertyRequests().forEach(pp -> {
           pitchPropertyService.add(new CreatePitchPropertyRequest(pp.getPropertyId(),pitchId));
        });



        return pitchDtoConverter.convert(tempPitch);
    }

    @Override
    public PitchDto delete(int pitchId) {
        Pitch deletedPitch = this.findById(pitchId);
        deletedPitch.setStatus(false);

        return pitchDtoConverter.convert(pitchDao.save(deletedPitch));
    }
}
