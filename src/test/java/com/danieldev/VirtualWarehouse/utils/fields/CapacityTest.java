package com.danieldev.VirtualWarehouse.utils.fields;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CapacityTest {
    @Test
    void capacityConstructorShouldReturnIllegalArgumentExceptionBecauseOfNull(){
        assertThrows(IllegalArgumentException.class, () -> new Capacity(null));
    }
}