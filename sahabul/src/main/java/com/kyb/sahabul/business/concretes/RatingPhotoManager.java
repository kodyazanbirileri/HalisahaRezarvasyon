package com.kyb.sahabul.business.concretes;

import com.kyb.sahabul.business.abstracts.RatingPhotoServices;
import com.kyb.sahabul.business.abstracts.RatingServices;
import com.kyb.sahabul.core.converter.RatingPhotoDtoConverter;
import com.kyb.sahabul.dataAccess.abstracts.RatingPhotoDao;
import com.kyb.sahabul.entities.concretes.RatingPhoto;
import com.kyb.sahabul.entities.dto.RatingPhotoDto;
import com.kyb.sahabul.entities.dto.createrequest.CreateRatingPhotoRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RatingPhotoManager implements RatingPhotoServices {
    private final RatingPhotoDao ratingPhotoDao;
    private final RatingPhotoDtoConverter ratingPhotoDtoConverter;
    private final RatingServices ratingServices;

    public RatingPhotoManager(RatingPhotoDao ratingPhotoDao, RatingPhotoDtoConverter ratingPhotoDtoConverter, RatingServices ratingServices) {
        this.ratingPhotoDao = ratingPhotoDao;
        this.ratingPhotoDtoConverter = ratingPhotoDtoConverter;
        this.ratingServices = ratingServices;
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
    public RatingPhotoDto add(CreateRatingPhotoRequest from) {
        RatingPhoto tempRatingPhoto = new RatingPhoto();

        tempRatingPhoto.setRating(ratingServices.findById(from.getRatingId()));
        tempRatingPhoto.setPhotoPath(from.getPhotoPath());

        return ratingPhotoDtoConverter.convert(ratingPhotoDao.save(tempRatingPhoto));
    }

    @Override
    public void delete(RatingPhoto ratingPhoto) {
        ratingPhotoDao.delete(ratingPhoto);
    }
}
