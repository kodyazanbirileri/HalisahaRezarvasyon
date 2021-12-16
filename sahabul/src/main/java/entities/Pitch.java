package entities;


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
    @GeneratedValue
    @Column(name = "id")
    private int id;

    @Column(name = "pitch_name")
    private String astroturfPitchName;

    @Column(name = "address")
    private String address;

    @Column(name = "start_hour")
    private int startHour;

    @Column(name = "end_hour")
    private int endHour;

    @ManyToMany(mappedBy = "pitch")
    private List<PitchProperty> pitchProperties;

    @OneToOne
    private City city;

    @OneToOne
    private District district;


    // Şehir - halı saha
    // İlçe - halı saha
    // Property - halı saha



}
