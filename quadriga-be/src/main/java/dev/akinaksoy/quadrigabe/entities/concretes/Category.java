package dev.akinaksoy.quadrigabe.entities.concretes;

import dev.akinaksoy.quadrigabe.entities.abstracts.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.Set;

@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "category")
public class Category extends BaseEntity {

    @Column(name = "name")
    private String name;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "category")
    private Set<Car> cars;

/*    @OneToMany(mappedBy = "category")
    @JsonManagedReference
    private List<Car> cars;     */


}
