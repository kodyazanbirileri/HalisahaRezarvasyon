package com.kyb.sahabul.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "hours")
@JsonIgnoreProperties({"hibernateLazyInitializer","reservations","pitchHours"})
public class Hour {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "start_hour")
    private int startHour;

    @Column(name = "end_hour")
    private int endHour;

    @OneToMany(mappedBy = "reservationHour")
    private List<Reservation> reservations;

}
