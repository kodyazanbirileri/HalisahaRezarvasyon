package entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "properties")
public class Properties
{
    @Id
    @GeneratedValue
    @Column(name = "id")
    private int id;

    @Column(name = "property_name")
    private String propertyName;
}
