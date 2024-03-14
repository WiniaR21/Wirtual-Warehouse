package com.danieldev.VirtualWarehouse.productName.productName;

import com.danieldev.VirtualWarehouse.department.department.Department;
import com.danieldev.VirtualWarehouse.utils.fields.Name;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Table(name = "product_name")
@Getter
@NoArgsConstructor
@Setter
public class ProductName {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(
                    name = "value",
                    column = @Column(name = "name", unique = true))
    })
    private Name name;

    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department producedByDepartment;

    public ProductName(ProductNameDTO productNameDTO) {
        this.name = new Name(productNameDTO.getProductName());
    }

}
