package com.danieldev.VirtualWarehouse.packaging.packaging;

import com.danieldev.VirtualWarehouse.utils.fields.Method;
import com.danieldev.VirtualWarehouse.utils.abstracts.ObjectDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;

@EqualsAndHashCode(callSuper = false)
@Data
@NoArgsConstructor
public class PackagingDTO extends ObjectDTO {
    private String packagingName;
    private BigDecimal capacity;
    private BigDecimal weight;

    public PackagingDTO(Packaging packaging) {
        this.id = packaging.getId();
        this.packagingName = packaging.getName().getValue();
        this.capacity = packaging.getCapacity().getValue();
        this.weight = packaging.getWeight().getValue();

        configureActions();
    }
    private void configureActions(){
        String mainPath = "/packaging-s";
        char slash = '/';

        addAction("Get packaging",
                mainPath + slash + id,
                Method.GET);

        addAction("Update packaging",
                mainPath + slash + id,
                Method.PUT);

        addAction("Remove packaging",
                mainPath + slash + id,
                Method.DELETE);
    }
}
