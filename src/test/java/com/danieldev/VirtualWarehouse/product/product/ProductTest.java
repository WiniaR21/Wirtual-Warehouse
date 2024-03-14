package com.danieldev.VirtualWarehouse.product.product;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static com.danieldev.VirtualWarehouse.utilsForTesting.UtilsForTesting.*;
import static org.junit.jupiter.api.Assertions.*;

class ProductTest {

    @BeforeEach
    void setUp() {
    }

    @Test
    void productConstructorShouldThrowIllegalArgumentExceptionBecauseOfWeight(){
        ProductDTO productDTO = new ProductDTO();
        productDTO.setGrossWeight(null);
        productDTO.setShift(Shift.FIRST_SHIFT);

        assertThrows(IllegalArgumentException.class,
                () -> new Product(
                        productDTO,
                        getValidProductName(),
                        getValidDepartment(),
                        getValidProductStatus(),
                        getValidPackaging()
                )
        );
    }
}