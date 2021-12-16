package com.kyb.sahabul.entities.concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "pitch_hours")
@Entity
public class PitchHour {

    @Id
    @Column(name = "id")
    @GeneratedValue
    private int id;

    //TODO: Saat - PitchHour bağlantısı.
    //TODO: pitch - pitchHour bağlantısı.

}
