package com.kyb.sahabul.entities.concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "system_users")
public class SystemUser {

    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "is_admin")
    private boolean isAdmin;


    @OneToOne(fetch = FetchType.LAZY, targetEntity = User.class, cascade = CascadeType.MERGE)
    @JoinColumn(name = "id")
    @MapsId
    private User user;

}