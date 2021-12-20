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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "reservation_date")
    private Date reservationDate;

    @Column(name = "reservation_note")
    private String note;

    @Column(name = "status")
    private boolean status;

    @ManyToOne(cascade = CascadeType.MERGE, targetEntity = Hour.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "reservation_id",referencedColumnName = "id")
    private Hour reservationHour;

    @ManyToOne(cascade = CascadeType.MERGE, targetEntity = Pitch.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "pitch_id", referencedColumnName = "id")
    private Pitch pitch;

    @ManyToOne(cascade = CascadeType.MERGE, targetEntity = User.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

}
