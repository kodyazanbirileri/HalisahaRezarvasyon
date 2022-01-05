package com.kyb.sahabul.dataAccess.abstracts;

import com.kyb.sahabul.entities.concretes.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface ReservationDao extends JpaRepository<Reservation, Integer> {

    List<Reservation> getAllByReservationDateIsContaining(Date date);

}
