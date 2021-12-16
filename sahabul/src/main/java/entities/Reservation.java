package entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "reservations")
public class Reservation {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private int id;

    @Column(name = "reservation_date")
    private Date reservationDate;

    @Column(name = "reservation_note")
    private String note;


    //TODO: Saat - rezervasyon ilişkisi.
    //TODO: Halısaha - rezervasyon ilişkisi.
    //TODO: Kullanıcı - rezervasyon ilişkisi.

}
