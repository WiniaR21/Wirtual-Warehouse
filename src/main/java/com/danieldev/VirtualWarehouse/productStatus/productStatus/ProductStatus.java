package com.danieldev.VirtualWarehouse.productStatus.productStatus;

import com.danieldev.VirtualWarehouse.utils.fields.Name;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "product_status")
@Getter
@NoArgsConstructor
@Setter
public class ProductStatus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(
                    name = "value",
                    column = @Column(name = "status", unique = true))
    })
    private Name name;

    public ProductStatus(ProductStatusDTO productStatusDTO) {
        this.name = new Name(productStatusDTO.getStatusName());
    }
}
