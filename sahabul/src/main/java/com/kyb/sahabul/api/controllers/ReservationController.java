package com.kyb.sahabul.api.controllers;

import com.kyb.sahabul.business.abstracts.ReservationServices;
import com.kyb.sahabul.entities.dto.OnlyIdDto;
import com.kyb.sahabul.entities.dto.ReservationDateWithPitchIdDto;
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

    @PostMapping(value = "/getReservationHoursByDateAndPitchId")
    public ResponseEntity<List<Integer>> getReservationHoursByDateAndPitchId
            (@RequestBody ReservationDateWithPitchIdDto reservationDateWithPitchIdDto) {
        return ResponseEntity.ok(reservationServices
                .getAllByReservationDateHoursLike(reservationDateWithPitchIdDto));
    }


    @PostMapping(value = "/add")
    public ResponseEntity<ReservationDto> add(@RequestBody CreateReservationRequest createReservationRequest) {
        return ResponseEntity.ok(reservationServices.add(createReservationRequest));
    }

    @PostMapping(value = "/delete")
    public ResponseEntity<ReservationDto> delete(@RequestBody OnlyIdDto onlyIdDto) {
        return ResponseEntity.ok(reservationServices.delete(onlyIdDto));
    }

}
