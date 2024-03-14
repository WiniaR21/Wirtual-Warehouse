package com.danieldev.VirtualWarehouse.packaging.packaging;

import com.danieldev.VirtualWarehouse.utils.fields.Capacity;
import com.danieldev.VirtualWarehouse.utils.fields.Name;

import com.danieldev.VirtualWarehouse.utils.fields.Weight;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "packaging")
@Getter
@NoArgsConstructor
public class Packaging {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(
                    name = "value",
                    column = @Column(name = "name", unique = true))
    })
    private Name name;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(
                    name = "value",
                    column = @Column(name = "capacity"))
    })
    private Capacity capacity;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "value",
                    column = @Column(name = "weight"))
    })
    private Weight weight;

    public Packaging(PackagingDTO request) {
        name = new Name(request.getPackagingName());
        capacity = new Capacity(request.getCapacity());
        weight = new Weight(request.getWeight());
    }
}
