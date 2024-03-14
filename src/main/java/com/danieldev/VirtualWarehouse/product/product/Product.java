package com.danieldev.VirtualWarehouse.product.product;

import com.danieldev.VirtualWarehouse.department.department.Department;
import com.danieldev.VirtualWarehouse.utils.fields.Capacity;
import com.danieldev.VirtualWarehouse.utils.fields.Weight;
import com.danieldev.VirtualWarehouse.packaging.packaging.Packaging;
import com.danieldev.VirtualWarehouse.productName.productName.ProductName;
import com.danieldev.VirtualWarehouse.productStatus.productStatus.ProductStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;


@Entity
@Table(name = "product")
@Getter
@NoArgsConstructor
@Setter
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Embedded
    private ProductWeight productWeight;

    @Enumerated(EnumType.STRING)
    private Shift shift;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(
                    name = "value",
                    column = @Column(name = "production_date"))
    })
    private ProductionDate productionDate;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "value",
                    column = @Column(name = "capacity"))
    })
    private Capacity capacity;

    @ManyToOne
    @JoinColumn(name = "packaging_id")
    private Packaging packaging;

    @ManyToOne
    @JoinColumn(name = "product_status_id")
    private ProductStatus productStatus;

    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;

    @ManyToOne
    @JoinColumn(name = "product_name_id")
    private ProductName productName;

    public Product(
            ProductDTO productDTO,
            ProductName productName,
            Department department,
            ProductStatus productStatus,
            Packaging packaging
    ) {
        this.productName = productName;
        this.packaging = packaging;
        this.productStatus = productStatus;
        this.department = department;

        if (productDTO.getProductionDate() != null){
            this.productionDate = new ProductionDate(productDTO.getProductionDate());
        }
        else {
            this.productionDate = new ProductionDate(new Date());
        }
        this.shift = productDTO.getShift();

        this.capacity = new Capacity(packaging.getCapacity().getValue());

        this.productWeight = new ProductWeight(
                new Weight(productDTO.getGrossWeight()),
                packaging
        );

    }
}
