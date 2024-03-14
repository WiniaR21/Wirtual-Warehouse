package com.danieldev.VirtualWarehouse.product.product;

import com.danieldev.VirtualWarehouse.utils.fields.Weight;
import com.danieldev.VirtualWarehouse.packaging.packaging.Packaging;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@NoArgsConstructor
@Getter
public class ProductWeight {

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(
                    name = "value",
                    column = @Column(name = "net_weight"))
    })
    private Weight netWeight;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "value",
                    column = @Column(name = "gross_weight"))
    })
    private Weight grossWeight;

    public ProductWeight(Weight grossWeight, Packaging packaging) {
        if (grossWeight == null){
            throw new IllegalArgumentException("GrossWeight cannot be null");
        }
        if (packaging == null){
            throw new IllegalArgumentException("Packaging cannot be null");
        }
        this.grossWeight = grossWeight;
        this.netWeight = grossWeight.subtract(packaging.getWeight());
    }
}

