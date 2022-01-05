package com.kyb.sahabul.business.concretes;

import com.kyb.sahabul.business.abstracts.HourServices;
import com.kyb.sahabul.business.abstracts.PitchServices;
import com.kyb.sahabul.business.abstracts.ReservationServices;
import com.kyb.sahabul.business.abstracts.UserServices;
import com.kyb.sahabul.core.converter.ReservationDtoConverter;
import com.kyb.sahabul.dataAccess.abstracts.ReservationDao;
import com.kyb.sahabul.entities.concretes.Reservation;
import com.kyb.sahabul.entities.dto.ReservationDateWithPitchIdDto;
import com.kyb.sahabul.entities.dto.ReservationDto;
import com.kyb.sahabul.entities.dto.createrequest.CreateReservationRequest;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReservationManager implements ReservationServices {
    private final ReservationDao reservationDao;
    private final ReservationDtoConverter reservationDtoConverter;
    private final PitchServices pitchServices;
    private final HourServices hourServices;
    private final UserServices userServices;

    public ReservationManager(ReservationDao reservationDao, ReservationDtoConverter reservationDtoConverter, PitchServices pitchServices, HourServices hourServices, UserServices userServices) {
        this.reservationDao = reservationDao;
        this.reservationDtoConverter = reservationDtoConverter;
        this.pitchServices = pitchServices;
        this.hourServices = hourServices;
        this.userServices = userServices;
    }

    @Override
    public List<ReservationDto> getAll() {
        return reservationDao.findAll().stream()
                .map(reservationDtoConverter::convert)
                .collect(Collectors.toList());
    }

    @Override
    public List<Integer> getAllByReservationDateHoursLike(ReservationDateWithPitchIdDto from) {
        
        List<ReservationDto> reservationDates = this.getAll().stream()
                .filter(r -> r.getReservationDate().equals(from.getDate()))
                .collect(Collectors.toList());

        List<Integer> hoursIds = reservationDates.stream()
                .filter(r -> r.getPitchId() == from.getPitchId())
                .map(fr -> fr.getReservationHour().getId())
                .collect(Collectors.toList());

        return hoursIds;
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
    public ReservationDto add(CreateReservationRequest from) {

        Reservation tempReservation = new Reservation();

        tempReservation.setReservationDate(from.getReservationDate());
        tempReservation.setNote(from.getNote());
        tempReservation.setStatus(true);
        tempReservation.setPitch(pitchServices.findById(from.getPitchId()));
        tempReservation.setReservationHour(hourServices.findById(from.getHourId()));
        tempReservation.setNote(from.getNote());
        tempReservation.setUser(userServices.findById(from.getUserId()));

        return reservationDtoConverter.convert(reservationDao.save(tempReservation));
    }

    @Override
    public ReservationDto delete(int reservationId) {

        Reservation deletedReservation = this.findById(reservationId);
        deletedReservation.setStatus(false);

        return reservationDtoConverter.convert(reservationDao.save(deletedReservation));
    }
}
