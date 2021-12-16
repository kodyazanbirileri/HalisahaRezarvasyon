package entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor
@Data
@NoArgsConstructor
@Table(name = "districts")
@Entity
public class District {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private int id;

    @Column(name = "district_name")
    private String districtName;

    @OneToOne(fetch = FetchType.LAZY, targetEntity = City.class, cascade = CascadeType.MERGE)
    @JoinColumn(name = "id")
    @MapsId
    private City city;

}
