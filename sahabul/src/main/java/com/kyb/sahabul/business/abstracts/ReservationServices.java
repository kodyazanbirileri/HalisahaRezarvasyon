package com.kyb.sahabul.business.abstracts;

import com.kyb.sahabul.entities.concretes.Reservation;
import com.kyb.sahabul.entities.dto.ReservationDateWithPitchIdDto;
import com.kyb.sahabul.entities.dto.ReservationDto;
import com.kyb.sahabul.entities.dto.createrequest.CreateReservationRequest;

import java.util.List;

public interface ReservationServices {
    List<ReservationDto> getAll();
    List<Integer> getAllByReservationDateHoursLike(ReservationDateWithPitchIdDto from);
    Reservation findById(int id);
    ReservationDto getById(int id);
    ReservationDto add(CreateReservationRequest createReservationRequest);
    ReservationDto delete(int reservationId);
}
