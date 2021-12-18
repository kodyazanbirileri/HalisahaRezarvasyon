package com.kyb.sahabul.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Table(name = "rating_photos")
@AllArgsConstructor
@NoArgsConstructor
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","rating"})
public class RatingPhoto {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private int id;

    @Column(name = "photo_path")
    private String photoPath;

    @ManyToOne(targetEntity = Rating.class, cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
    @JoinColumn(name = "rating_id",referencedColumnName = "id")
    private Rating rating;
}
