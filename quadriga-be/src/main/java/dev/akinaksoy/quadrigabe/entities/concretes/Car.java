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
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "cars")
public class Car extends BaseEntity {

    @Column(name = "is_available")
    private boolean isAvailable;

    @Column(name= "year")
    private int year;

    @Column(name = "mileage_counter")
    private int mileageCounter;

    @Column(name = "seating_capacity")
    private int seatingCapacity;

    @Column(name = "plate")
    private String plate;

    @Column(name = "description")
    private String description;

    @Column(name = "price")
    private double price;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "color_id")
    private Color color;

    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;

    @OneToMany(mappedBy = "car", cascade = CascadeType.ALL)
    private List<Image> images;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "model_id")
    private Model model;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="fuel_types_id", referencedColumnName= "id")
    private FuelType fuelType;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="transmission_types_id", referencedColumnName= "id")
    private TransmissionType transmissionType;
}
