package com.danieldev.VirtualWarehouse.utils.fields;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Embeddable
@NoArgsConstructor
@Getter
public class Weight {
    @Column(name = "weight")
    private BigDecimal value;

    public Weight(BigDecimal value) {
        if (value == null) {
            throw new IllegalArgumentException("Weight cannot be null");
        }
        if (value.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("Weight cannot be negative");
        }
        this.value = setScale(value);
    }

    public Weight add(Weight weight) {
        return new Weight(this.value.add(weight.value));
    }

    public Weight subtract(Weight weight) {
        return new Weight(this.value.subtract(weight.value));
    }

    private BigDecimal setScale(BigDecimal input) {
        return input.setScale(2, RoundingMode.HALF_EVEN);
    }
}

