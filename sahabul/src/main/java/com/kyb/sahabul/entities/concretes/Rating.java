package com.kyb.sahabul.entities.concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "ratings")
public class Rating {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "rate")
    private int rate;

    @Column(name = "rate_detail")
    private String rateDetail;

    @Column(name = "status")
    private boolean status;

    @OneToMany(mappedBy = "rating")
    private List<RatingPhoto> ratingPhotos;

    @OneToOne(fetch = FetchType.LAZY, targetEntity = Reservation.class, cascade = CascadeType.MERGE)
    @JoinColumn(name = "reservation_id", referencedColumnName = "id")
    private Reservation reservation;


}
