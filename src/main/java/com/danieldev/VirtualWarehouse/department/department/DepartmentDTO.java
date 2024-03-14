package com.danieldev.VirtualWarehouse.department.department;

import com.danieldev.VirtualWarehouse.utils.abstracts.ObjectDTO;
import com.danieldev.VirtualWarehouse.utils.fields.Method;
import com.danieldev.VirtualWarehouse.product.product.ProductDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@EqualsAndHashCode(callSuper = false)
@Data
@NoArgsConstructor
public class DepartmentDTO extends ObjectDTO {
    private String departmentName;
    private BigDecimal totalCapacity;
    private BigDecimal currentCapacity;
    private List<ProductDTO> productList = new ArrayList<>();
    private List<String> produces = new ArrayList<>();

    public DepartmentDTO(Department department) {
        this.id = department.getId();
        this.departmentName = department.getName().getValue();
        this.totalCapacity = department.getCapacity().getTotalCapacity().getValue();
        this.currentCapacity = department.getCapacity().getCurrentCapacity().getValue();

        department.getProducts().forEach(product ->
                productList.add(new ProductDTO(product)));

        department.getProduces().forEach(productName ->
                produces.add(productName.getName().getValue()));

        configureActions();
    }
    private void configureActions(){
        String mainPath = "/departments";
        char slash = '/';

        addAction(
                "Get department",
                mainPath + slash + id ,
                Method.GET);

        addAction(
                "Add to produces",
                mainPath + slash + id + "/removeFromProduces?productNameId={???}",
                Method.PUT);

        addAction(
                "Remove from produces",
                mainPath + slash + id ,
                Method.PUT);
    }

}
