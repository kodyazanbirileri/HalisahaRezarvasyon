package com.kyb.sahabul.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "reservations")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","reservationHour","pitch","user"})
public class Reservation {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private int id;

    @Column(name = "reservation_date")
    private Date reservationDate;

    @Column(name = "reservation_note")
    private String note;

    @ManyToOne()
    private Hour reservationHour;

    @ManyToOne()
    private Pitch pitch;

    @ManyToOne()
    private User user;

}
