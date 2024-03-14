package com.danieldev.VirtualWarehouse.utils.fields;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class WeightTest {

    @Test
    void weightConstructorShouldReturnIllegalArgumentExceptionBecauseOfNull(){
        assertThrows(IllegalArgumentException.class,
                () -> new Weight(null));
    }
    @Test
    void weightConstructorShouldReturnIllegalArgumentExceptionBecauseOfNegative(){
        assertThrows(IllegalArgumentException.class,
                () -> new Weight(new BigDecimal(-1)));
    }
}