package com.kyb.sahabul.business.concretes;

import com.kyb.sahabul.business.abstracts.RatingServices;
import com.kyb.sahabul.core.converter.RatingDtoConverter;
import com.kyb.sahabul.dataAccess.abstracts.RatingDao;
import com.kyb.sahabul.entities.concretes.Rating;
import com.kyb.sahabul.entities.dto.RatingDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RatingManager implements RatingServices {

    private final RatingDao ratingDao;
    private final RatingDtoConverter ratingDtoConverter;
    public RatingManager(RatingDao ratingDao, RatingDtoConverter ratingDtoConverter) {
        this.ratingDao = ratingDao;
        this.ratingDtoConverter = ratingDtoConverter;
    }

    @Override
    public List<RatingDto> getAll() {
        return ratingDao.findAll().stream()
                .map(ratingDtoConverter::convert)
                .collect(Collectors.toList());
    }

    @Override
    public RatingDto getById(int id) {
        return ratingDtoConverter.convert(ratingDao.getOne(id));
    }

    @Override
    public RatingDto add(Rating rating) {
        return ratingDtoConverter.convert(ratingDao.save(rating));
    }

    @Override
    public void delete(Rating rating) {
        ratingDao.delete(rating);
    }
}
