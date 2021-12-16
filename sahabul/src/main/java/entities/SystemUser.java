package entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

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



    //TODO: Admin - user tablo ilişkisi yapılacak.
}
