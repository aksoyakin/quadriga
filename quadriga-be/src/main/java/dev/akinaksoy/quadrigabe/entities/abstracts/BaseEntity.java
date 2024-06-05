package dev.akinaksoy.quadrigabe.entities.abstracts;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDate;
import java.util.Date;

/**
 * Abstract base entity class serving as a foundation for other entity classes in the Quadriga project.
 * Includes common fields like id, createdDate, and updatedDate to be inherited by other entity classes.
 *
 * @author AKINAKSOY
 */

@MappedSuperclass
@Data
public class BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "created_date")
    @CreationTimestamp
    private LocalDate createdDate;

    @Column(name = "update_date")
    @UpdateTimestamp
    private LocalDate updatedDate;
}
