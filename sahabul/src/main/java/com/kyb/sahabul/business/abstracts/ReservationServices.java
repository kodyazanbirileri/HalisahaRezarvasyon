package com.kyb.sahabul.business.abstracts;

import com.kyb.sahabul.entities.concretes.Reservation;
import com.kyb.sahabul.entities.dto.ReservationDto;

import java.util.List;

public interface ReservationServices {
    List<ReservationDto> getAll();
    Reservation findById(int id);
    ReservationDto getById(int id);
    ReservationDto add(Reservation reservation);
    void delete(Reservation reservation);
}
