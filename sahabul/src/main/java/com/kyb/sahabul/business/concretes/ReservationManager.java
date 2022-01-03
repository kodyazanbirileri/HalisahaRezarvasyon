package com.kyb.sahabul.business.concretes;

import com.kyb.sahabul.business.abstracts.ReservationServices;
import com.kyb.sahabul.core.converter.ReservationDtoConverter;
import com.kyb.sahabul.dataAccess.abstracts.ReservationDao;
import com.kyb.sahabul.entities.concretes.Reservation;
import com.kyb.sahabul.entities.dto.ReservationDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReservationManager implements ReservationServices {
    private final ReservationDao reservationDao;
    private final ReservationDtoConverter reservationDtoConverter;

    public ReservationManager(ReservationDao reservationDao, ReservationDtoConverter reservationDtoConverter) {
        this.reservationDao = reservationDao;
        this.reservationDtoConverter = reservationDtoConverter;
    }

    @Override
    public List<ReservationDto> getAll() {
        return reservationDao.findAll().stream()
                .map(reservationDtoConverter::convert)
                .collect(Collectors.toList());
    }

    @Override
    public Reservation findById(int id) {
        return reservationDao.getOne(id);
    }

    @Override
    public ReservationDto getById(int id) {
        return reservationDtoConverter.convert(reservationDao.getOne(id));
    }

    @Override
    public ReservationDto add(Reservation reservation) {
        return reservationDtoConverter.convert(reservationDao.save(reservation));
    }

    @Override
    public void delete(Reservation reservation) {
        reservationDao.delete(reservation);
    }
}
