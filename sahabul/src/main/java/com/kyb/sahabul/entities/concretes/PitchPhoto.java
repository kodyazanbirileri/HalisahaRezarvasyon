package com.kyb.sahabul.entities.concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Table(name = "pitch_photos")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class PitchPhoto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "photo_path")
    private String photoPath;

    @ManyToOne(targetEntity = Pitch.class, cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
    @JoinColumn(name = "pitch_id", referencedColumnName = "id")
    private Pitch pitch;
}
