package com.kyb.sahabul.business.concretes;

import com.kyb.sahabul.business.abstracts.RatingPhotoServices;
import com.kyb.sahabul.business.abstracts.RatingServices;
import com.kyb.sahabul.business.abstracts.ReservationServices;
import com.kyb.sahabul.core.converter.RatingDtoConverter;
import com.kyb.sahabul.dataAccess.abstracts.RatingDao;
import com.kyb.sahabul.entities.concretes.Rating;
import com.kyb.sahabul.entities.dto.RatingDto;
import com.kyb.sahabul.entities.dto.createrequest.CreateRatingPhotoForRatingRequest;
import com.kyb.sahabul.entities.dto.createrequest.CreateRatingPhotoRequest;
import com.kyb.sahabul.entities.dto.createrequest.CreateRatingRequest;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RatingManager implements RatingServices {

    private final RatingDao ratingDao;
    private final RatingDtoConverter ratingDtoConverter;
    private final ReservationServices reservationServices;
    private final RatingPhotoServices ratingPhotoServices;

    @Lazy
    public RatingManager(RatingDao ratingDao, RatingDtoConverter ratingDtoConverter, ReservationServices reservationServices, RatingPhotoServices ratingPhotoServices) {
        this.ratingDao = ratingDao;
        this.ratingDtoConverter = ratingDtoConverter;
        this.reservationServices = reservationServices;
        this.ratingPhotoServices = ratingPhotoServices;
    }

    @Override
    public List<RatingDto> getAll() {
        return ratingDao.findAll().stream()
                .map(ratingDtoConverter::convert)
                .collect(Collectors.toList());
    }

    @Override
    public Rating findById(int id) {
        return ratingDao.getOne(id);
    }

    @Override
    public RatingDto getById(int id) {
        return ratingDtoConverter.convert(ratingDao.getOne(id));
    }

    @Override
    public RatingDto add(CreateRatingRequest from) {
        Rating tempRating = new Rating();

        tempRating.setRate(from.getRate());
        tempRating.setRateDetail(from.getRateDetail());
        tempRating.setReservation(reservationServices.findById(from.getReservationId()));

        int ratingId = ratingDao.save(tempRating).getId();

        from.getRatingPhotoForRatings().forEach(rp ->
               ratingPhotoServices.add(new CreateRatingPhotoRequest(rp.getPhotoPath(),ratingId)));

        return ratingDtoConverter.convert(tempRating);
    }

    @Override
    public void delete(Rating rating) {
        ratingDao.delete(rating);
    }
}
