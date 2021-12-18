package com.kyb.sahabul.entities.concretes;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "pitch_properties")
@AllArgsConstructor
@NoArgsConstructor
@Data
@JsonIgnoreProperties({"hibernateLazyInıtializer","handler","pitch","property"})
public class PitchProperty {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private int id;

    @ManyToOne()
    @JoinColumn(name = "pitch_id")
    private Pitch pitch;

    @ManyToOne
    @JoinColumn(name = "property_id")
    private Property property;

    // Pitch - pitch property bağlantısı
    // Property - pitch property bağlantısı
}
