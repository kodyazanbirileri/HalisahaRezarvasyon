package com.kyb.sahabul.entities.concretes;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.kyb.sahabul.entities.dto.DistrictDto;
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
@JsonIgnoreProperties({"hibernateLazyInıtializer","handler","pitchPhoto","pitchHour","reservations","pitchProperties"})
public class Pitch {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "pitch_name")
    private String pitchName;

    @Column(name = "pitch_number")
    private String pitchNumber;

    @Column(name = "address")
    private String address;

    @Column(name = "start_hour")
    private String startHour = "12:00";

    @Column(name = "end_hour")
    private String endHour = "03:00";

    @Column(name = "status")
    private boolean status = true;

    @OneToMany(mappedBy = "pitch")
    private List<Reservation> reservations;

    @OneToMany(mappedBy = "pitch")
    private List<PitchProperty> pitchProperties;

    @OneToMany(mappedBy = "pitch")
    private List<PitchPhoto> pitchPhotos;

    @ManyToOne(fetch = FetchType.LAZY, targetEntity = District.class, cascade = CascadeType.MERGE)
    @JoinColumn(name = "district_id", referencedColumnName = "id")
    private District district;




}
