package com.danieldev.VirtualWarehouse.product.product;

import com.danieldev.VirtualWarehouse.utils.fields.Weight;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static com.danieldev.VirtualWarehouse.utilsForTesting.UtilsForTesting.getValidPackaging;
import static org.junit.jupiter.api.Assertions.*;

class ProductWeightTest {
    @Test
    void productWeightConstructorShouldReturnIllegalArgumentExceptionBecauseOfGrossWeight(){
        assertThrows(IllegalArgumentException.class,
                () -> new ProductWeight(null, getValidPackaging()));
    }
    @Test
    void productWeightConstructorShouldReturnIllegalArgumentExceptionBecauseOfPackaging(){
        assertThrows(IllegalArgumentException.class,
                () -> new ProductWeight(new Weight(new BigDecimal(1)), null));
    }

}