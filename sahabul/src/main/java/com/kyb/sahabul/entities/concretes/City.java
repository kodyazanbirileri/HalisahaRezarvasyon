package com.kyb.sahabul.entities.concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor
@Data
@NoArgsConstructor
@Entity
@Table(name = "cities")
public class City
{
    @Id
    @GeneratedValue
    @Column(name = "id")
    private int id;

    @Column(name = "city_name")
    private String cityName;
}