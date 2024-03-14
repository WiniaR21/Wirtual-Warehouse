package com.danieldev.VirtualWarehouse.product.product;

import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;

@Getter
@Embeddable
@NoArgsConstructor
public class ProductionDate {

    private Date value;

    public ProductionDate(Date value) {
        if (value == null) {
            throw new IllegalArgumentException("Production date cannot be null");
        }
        this.value = value;
    }

}
