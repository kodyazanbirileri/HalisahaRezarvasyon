package entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Table(name = "rating_photos")
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class RatingPhoto {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private int id;

    @Column(name = "photo_path")
    private String photoPath;

    //TODO: Rate - Rate photo bağlantısı
}
