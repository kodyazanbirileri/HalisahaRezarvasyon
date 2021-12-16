package entities;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "pitchs")
public class AstroturfPitch {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private int id;

    @Column(name = "pitch_name")
    private String astroturfPitchName;

    @Column(name = "address")
    private String address;

    //TODO: Şehir - halı saha
    //TODO: İlçe - halı saha
    //TODO: Property - halı saha



}
