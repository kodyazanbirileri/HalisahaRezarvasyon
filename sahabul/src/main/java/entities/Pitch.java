package entities;


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
    @GeneratedValue
    @Column(name = "id")
    private int id;

    @Column(name = "pitch_name")
    private String astroturfPitchName;

    @Column(name = "address")
    private String address;

    @OneToMany(mappedBy = "pitch")
    private List<Reservation> reservations;


    //TODO: Şehir - halı saha
    //TODO: İlçe - halı saha
    //TODO: Property - halı saha
    //TODO: Owner - halı saha


}
