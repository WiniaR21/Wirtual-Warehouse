package com.danieldev.VirtualWarehouse.utils.fields;

import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Getter
@Embeddable
@NoArgsConstructor
public class Capacity {
    //  Capacity in m^3
    private BigDecimal value;

    public Capacity(BigDecimal value) {
        if (value == null){
            throw new IllegalArgumentException("Capacity cannot be null");
        }
        this.value = setScale(value);
    }
    public Capacity add(Capacity weight) {
        return new Capacity(this.value.add(weight.value));
    }

    public Capacity subtract(Capacity weight) {
        return new Capacity(this.value.subtract(weight.value));
    }

    private BigDecimal setScale(BigDecimal input) {
        return input.setScale(2, RoundingMode.HALF_EVEN);
    }
}
