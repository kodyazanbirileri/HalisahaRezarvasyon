package com.kyb.sahabul.business.concretes;

import com.kyb.sahabul.business.abstracts.RatingPhotoServices;
import com.kyb.sahabul.core.converter.RatingPhotoDtoConverter;
import com.kyb.sahabul.dataAccess.abstracts.RatingPhotoDao;
import com.kyb.sahabul.entities.concretes.RatingPhoto;
import com.kyb.sahabul.entities.dto.RatingPhotoDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RatingPhotoManager implements RatingPhotoServices {
    private final RatingPhotoDao ratingPhotoDao;
    private final RatingPhotoDtoConverter ratingPhotoDtoConverter;

    public RatingPhotoManager(RatingPhotoDao ratingPhotoDao, RatingPhotoDtoConverter ratingPhotoDtoConverter) {
        this.ratingPhotoDao = ratingPhotoDao;
        this.ratingPhotoDtoConverter = ratingPhotoDtoConverter;
    }

    @Override
    public List<RatingPhotoDto> getAll() {
        return ratingPhotoDao.findAll().stream()
                .map(ratingPhotoDtoConverter::convert)
                .collect(Collectors.toList());
    }

    @Override
    public RatingPhotoDto getById(int id) {
        return ratingPhotoDtoConverter.convert(ratingPhotoDao.getOne(id));
    }

    @Override
    public RatingPhotoDto add(RatingPhoto ratingPhoto) {
        return ratingPhotoDtoConverter.convert(ratingPhotoDao.save(ratingPhoto));
    }

    @Override
    public void delete(RatingPhoto ratingPhoto) {
        ratingPhotoDao.delete(ratingPhoto);
    }
}
