package com.danieldev.VirtualWarehouse.product.product;


import com.danieldev.VirtualWarehouse.utils.abstracts.ObjectDTO;
import com.danieldev.VirtualWarehouse.utils.fields.Method;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

@EqualsAndHashCode(callSuper = false)
@Data
@Getter
@NoArgsConstructor
public class ProductDTO extends ObjectDTO {
    private String productName;
    private BigDecimal grossWeight;
    private BigDecimal netWeight;
    private BigDecimal capacity;
    private String packaging;
    private String location;
    private String productStatus;
    private Shift shift;
    private Date productionDate;
    public ProductDTO(Product product) {
        this.id = product.getId();
        this.productName = product.getProductName().getName().getValue();
        this.netWeight = product.getProductWeight().getNetWeight().getValue();
        this.grossWeight = product.getProductWeight().getGrossWeight().getValue();
        this.capacity = product.getCapacity().getValue();
        this.packaging = product.getPackaging().getName().getValue();
        this.location = product.getDepartment().getName().getValue();
        this.productStatus = product.getProductStatus().getName().getValue();
        this.shift = product.getShift();
        this.productionDate = product.getProductionDate().getValue();
        configureActions();
    }

    private void configureActions(){
        String mainPath = "/products";
        char slash = '/';

        addAction("Get product",
                mainPath + slash + id,
                Method.GET);

        addAction("Delete product",
                mainPath + slash + id,
                Method.DELETE);

        addAction("Transport product",
                mainPath + slash + id + "/transport?departmentId={???}",
                Method.PUT);
    }
}
