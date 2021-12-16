package entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "ratings")
public class Rating {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private int id;

    @Column(name = "rate")
    private int rate;

    @Column(name = "rate_detail")
    private String rateDetail;

    @OneToMany(mappedBy = "rating")
    private List<RatingPhoto> ratingPhotos;



}
