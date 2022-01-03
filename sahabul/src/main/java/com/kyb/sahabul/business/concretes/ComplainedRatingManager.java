package com.kyb.sahabul.business.concretes;

import com.kyb.sahabul.business.abstracts.ComplainedRatingServices;
import com.kyb.sahabul.business.abstracts.ReservationServices;
import com.kyb.sahabul.core.converter.ComplainedRatingDtoConverter;
import com.kyb.sahabul.dataAccess.abstracts.ComplainedRatingDao;
import com.kyb.sahabul.entities.concretes.ComplainedRating;
import com.kyb.sahabul.entities.dto.ComplainedRatingDto;
import com.kyb.sahabul.entities.dto.ReservationDto;
import com.kyb.sahabul.entities.dto.createrequest.CreateComplainedRating;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ComplainedRatingManager implements ComplainedRatingServices {
    private final ComplainedRatingDao complainedRatingDao;
    private final ComplainedRatingDtoConverter complainedRatingDtoConverter;
    private final ReservationServices reservationServices;

    public ComplainedRatingManager(ComplainedRatingDao complainedRatingDao,
                                   ComplainedRatingDtoConverter complainedRatingDtoConverter,
                                   ReservationServices reservationServices) {
        this.complainedRatingDao = complainedRatingDao;
        this.complainedRatingDtoConverter = complainedRatingDtoConverter;
        this.reservationServices = reservationServices;
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
    public ComplainedRatingDto add(CreateComplainedRating from) {

        ComplainedRating tempComplainedRating = new ComplainedRating();
        tempComplainedRating.setConfirmed(false);
        tempComplainedRating.setReservation(reservationServices.findById(from.getReservationId()));


        return complainedRatingDtoConverter.convert(complainedRatingDao.save(tempComplainedRating));
    }

    @Override
    public void delete(ComplainedRating complainedRating) {
        complainedRatingDao.delete(complainedRating);
    }
}
