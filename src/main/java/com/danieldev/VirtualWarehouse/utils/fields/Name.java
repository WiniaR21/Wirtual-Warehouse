package com.danieldev.VirtualWarehouse.utils.fields;

import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Embeddable
@NoArgsConstructor
public class Name {
    private String value;

    public Name(String value) {
        if (value == null) {
            throw new IllegalArgumentException("Name cannot be null");
        }
        if (value.isBlank()) {
            throw new IllegalArgumentException("Name cannot be empty");
        }
        this.value = value;
    }

}
