package com.kyb.sahabul.entities.concretes;


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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "district_name")
    private String districtName;

    @ManyToOne(fetch = FetchType.LAZY, targetEntity = City.class, cascade = CascadeType.MERGE)
    @JoinColumn(name = "city_id",referencedColumnName = "id")
    private City city;

}
