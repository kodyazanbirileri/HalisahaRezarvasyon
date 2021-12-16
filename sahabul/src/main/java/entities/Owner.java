package entities;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "owner")
public class Owner {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "owner_id")
    private int id;

    @OneToMany
    private AstroturfPitch astroturfPitch;


    @OneToOne(fetch = FetchType.LAZY, targetEntity = User.class, cascade = {CascadeType.MERGE,CascadeType.PERSIST})
    private User user;







}
