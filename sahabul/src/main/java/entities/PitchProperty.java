package entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "pitch_properties")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class PitchProperty {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private int id;

    //TODO: Pitch - pitch property bağlantısı
    //TODO: Property - pitch property bağlantısı
}
