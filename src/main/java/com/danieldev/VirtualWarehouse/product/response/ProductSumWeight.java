package com.danieldev.VirtualWarehouse.product.response;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
public class ProductSumWeight {
    private String productName;
    private BigDecimal grossWeight;
    private BigDecimal netWeight;

    public BigDecimal getGrossWeight() {
        return grossWeight == null ? new BigDecimal(0) : grossWeight;
    }

    public BigDecimal getNetWeight() {
        return netWeight == null ? new BigDecimal(0) : netWeight;
    }
}
