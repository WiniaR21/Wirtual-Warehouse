package com.danieldev.VirtualWarehouse.productName.productName;


import com.danieldev.VirtualWarehouse.utils.abstracts.ObjectDTO;
import com.danieldev.VirtualWarehouse.department.department.Department;
import com.danieldev.VirtualWarehouse.utils.fields.Method;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = false)
@Data
@NoArgsConstructor
public class ProductNameDTO extends ObjectDTO {
    private String productName;
    private String producedByDepartment;

    public ProductNameDTO(ProductName productName, Department department) {
        this.id = productName.getId();
        this.productName = productName.getName().getValue();

        if(department == null)
        {
            this.producedByDepartment = "Unknown";
        }
        else
        {
            this.producedByDepartment = department.getName().getValue();
        }

        configureActions();
    }
    private void configureActions(){
        String mainPath = "/productNames";
        char slash = '/';

        addAction(
                "Get product name",
                mainPath + slash + id,
                Method.GET);

        addAction("Remove product name",
                mainPath + slash + id,
                Method.DELETE);

        addAction("Update product name",
                mainPath + slash + id,
                Method.PUT);
    }
}
