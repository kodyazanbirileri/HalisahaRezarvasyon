package com.kyb.sahabul.entities.concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "complained_rating")
public class ComplainedRating {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "is_confirmed")
    private boolean isConfirmed;

    @OneToOne(fetch = FetchType.LAZY, targetEntity = Reservation.class, cascade = CascadeType.MERGE)
    @JoinColumn(name = "reservation_id", referencedColumnName = "id")
    private Reservation reservation;


}
