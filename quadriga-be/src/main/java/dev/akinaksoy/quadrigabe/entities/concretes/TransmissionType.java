package dev.akinaksoy.quadrigabe.entities.concretes;

import dev.akinaksoy.quadrigabe.entities.abstracts.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "transmission_types")
public class TransmissionType extends BaseEntity {

    @Column(name = "type")
    private String type;

    @OneToMany(mappedBy = "transmissionType", fetch = FetchType.LAZY)
    private List<Car> cars;
}
