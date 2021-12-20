package com.kyb.sahabul.entities.concretes;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "pitchs")
public class Pitch {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "pitch_name")
    private String pitchName;

    @Column(name = "address")
    private String address;

    @OneToMany(mappedBy = "pitch")
    private List<Reservation> reservations;

    @OneToMany(mappedBy = "pitch")
    private List<PitchProperty> pitchProperties;

    @OneToMany(mappedBy = "pitch")
    private List<PitchHour> pitchHours;

    @OneToMany(mappedBy = "pitch")
    private List<PitchPhoto> pitchPhotos;

    @OneToOne(fetch = FetchType.LAZY, targetEntity = City.class, cascade = CascadeType.MERGE)
    @JoinColumn(name = "city_id",referencedColumnName = "id")
    private City city;

    @OneToOne(fetch = FetchType.LAZY, targetEntity = City.class, cascade = CascadeType.MERGE)
    @JoinColumn(name = "district_id", referencedColumnName = "id")
    private District district;




}
