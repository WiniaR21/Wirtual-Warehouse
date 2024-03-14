package com.danieldev.VirtualWarehouse.productStatus.productStatus;

import com.danieldev.VirtualWarehouse.utils.abstracts.ObjectDTO;
import com.danieldev.VirtualWarehouse.utils.fields.Method;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = false)
@Data
@NoArgsConstructor
public class ProductStatusDTO extends ObjectDTO {
    private String statusName;
    public ProductStatusDTO(ProductStatus productStatus) {
        this.id = productStatus.getId();
        this.statusName = productStatus.getName().getValue();

        configureActions();
    }
    private void configureActions(){
        String mainPath = "/productStatuses";
        char slash = '/';

        addAction("Get product status",
                mainPath + slash + id,
                Method.GET);

        addAction("Remove product status",
                mainPath + slash + id ,
                Method.DELETE);

        addAction("Update product status",
                mainPath + slash + id,
                Method.PUT);

    }
}
