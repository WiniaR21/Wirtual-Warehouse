package com.danieldev.VirtualWarehouse.department.department;

import com.danieldev.VirtualWarehouse.utils.fields.Capacity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@NoArgsConstructor
@Getter
public class DepartmentCapacity {
    @Embedded
    @AttributeOverrides({
            @AttributeOverride(
                    name = "value",
                    column = @Column(name = "total_capacity"))
    })
    private Capacity totalCapacity;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "value",
                    column = @Column(name = "current_capacity"))
    })
    private Capacity currentCapacity;

    public DepartmentCapacity(Capacity totalCapacity) {
        this.totalCapacity = totalCapacity;
        this.currentCapacity = totalCapacity;
    }

    public void lowerCurrentCapacity(Capacity capacity){
        currentCapacity = new Capacity(currentCapacity.subtract(capacity).getValue());
    }

    public void increaseCurrentCapacity(Capacity capacity){
        currentCapacity = new Capacity(currentCapacity.add(capacity).getValue());
    }
}
