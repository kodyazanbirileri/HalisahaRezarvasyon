package com.kyb.sahabul.entities.concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "properties")
public class Property
{
    @Id
    @GeneratedValue
    @Column(name = "id")
    private int id;

    @Column(name = "property_name")
    private String propertyName;

   // @OneToMany()
   // private List<PitchProperty> pitchProperties;
}
