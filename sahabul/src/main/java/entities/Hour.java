package entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "hours")
public class Hour {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private int id;

    @Column(name = "start_hour")
    private int startHour;

    @Column(name = "end_hour")
    private int endHour;

}
