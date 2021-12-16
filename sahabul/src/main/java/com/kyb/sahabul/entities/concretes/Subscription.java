package com.kyb.sahabul.entities.concretes;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "subscriptions")
public class Subscription {

    @Id
    @Column(name = "id")
    @GeneratedValue
    private int id;

    @Column(name = "status")
    private boolean status;

    @OneToOne(targetEntity = Reservation.class, cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
    @JoinColumn(name = "id")
    @MapsId
    private Reservation reservation;

}
