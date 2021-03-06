package com.kyb.sahabul.entities.concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "owners")
public class Owner {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "is_confirmed")
    private boolean isConfirmed;

    @OneToOne(fetch = FetchType.LAZY, targetEntity = User.class, cascade = {CascadeType.MERGE,CascadeType.PERSIST})
    @JoinColumn(name= "user_id",referencedColumnName = "id")
    private User user;

}
