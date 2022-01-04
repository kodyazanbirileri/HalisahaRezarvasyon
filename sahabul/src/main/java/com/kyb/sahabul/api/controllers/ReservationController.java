package com.kyb.sahabul.api.controllers;

import com.kyb.sahabul.business.abstracts.ReservationServices;
import com.kyb.sahabul.dataAccess.abstracts.ReservationDao;
import com.kyb.sahabul.entities.concretes.Reservation;
import com.kyb.sahabul.entities.dto.ReservationDto;
import com.kyb.sahabul.entities.dto.createrequest.CreateReservationRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/reservation")
public class ReservationController {
    private final ReservationServices reservationServices;

    public ReservationController(ReservationServices reservationServices) {
        this.reservationServices = reservationServices;
    }

    @GetMapping(value = "/getAll")
    public ResponseEntity<List<ReservationDto>> getAll() {
        return ResponseEntity.ok(reservationServices.getAll());
    }

    @GetMapping(value = "/getById")
    public ResponseEntity<ReservationDto> getById(@RequestParam int id) {
        return ResponseEntity.ok(reservationServices.getById(id));
    }

    @PostMapping(value = "/add")
    public ResponseEntity<ReservationDto> add(@RequestBody CreateReservationRequest createReservationRequest) {
        return ResponseEntity.ok(reservationServices.add(createReservationRequest));
    }

    @PostMapping(value = "/delete")
    public ResponseEntity<ReservationDto> delete(@RequestParam int reservationId) {
        return ResponseEntity.ok(reservationServices.delete(reservationId));
    }

}
