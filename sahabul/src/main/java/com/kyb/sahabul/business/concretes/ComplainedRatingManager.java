package com.kyb.sahabul.business.concretes;

import com.kyb.sahabul.business.abstracts.ComplainedRatingServices;
import com.kyb.sahabul.core.converter.ComplainedRatingDtoConverter;
import com.kyb.sahabul.dataAccess.abstracts.ComplainedRatingDao;
import com.kyb.sahabul.entities.concretes.ComplainedRating;
import com.kyb.sahabul.entities.dto.ComplainedRatingDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ComplainedRatingManager implements ComplainedRatingServices {
    private final ComplainedRatingDao complainedRatingDao;
    private final ComplainedRatingDtoConverter complainedRatingDtoConverter;

    public ComplainedRatingManager(ComplainedRatingDao complainedRatingDao, ComplainedRatingDtoConverter complainedRatingDtoConverter) {
        this.complainedRatingDao = complainedRatingDao;
        this.complainedRatingDtoConverter = complainedRatingDtoConverter;
    }

    @Override
    public List<ComplainedRatingDto> getAll() {
        return complainedRatingDao.findAll().stream()
                .map(complainedRatingDtoConverter::convert)
                .collect(Collectors.toList());
    }

    @Override
    public ComplainedRatingDto getById(int id) {
        return complainedRatingDtoConverter.convert(complainedRatingDao.getOne(id));
    }

    @Override
    public ComplainedRatingDto add(ComplainedRating complainedRating) {
        return complainedRatingDtoConverter.convert(complainedRatingDao.save(complainedRating));
    }

    @Override
    public void delete(ComplainedRating complainedRating) {
        complainedRatingDao.delete(complainedRating);
    }
}
