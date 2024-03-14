package com.danieldev.VirtualWarehouse.department.department;

import com.danieldev.VirtualWarehouse.utils.fields.Capacity;
import com.danieldev.VirtualWarehouse.utils.fields.Name;
import com.danieldev.VirtualWarehouse.product.product.Product;
import com.danieldev.VirtualWarehouse.productName.productName.ProductName;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "department")
@Getter
@NoArgsConstructor
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(
                    name = "value",
                    column = @Column(name = "department_name", unique = true))
    })
    private Name name;

    @Embedded
    private DepartmentCapacity capacity;

    // Products that are in department
    @OneToMany(mappedBy = "department")
    private List<Product> products = new ArrayList<>();


    //  Product types that department produces
    @OneToMany(mappedBy = "producedByDepartment")
    private List<ProductName> produces = new ArrayList<>();

    public Department(DepartmentDTO departmentDTO) {
        this.name = new Name(departmentDTO.getDepartmentName());
        this.capacity = new DepartmentCapacity(new Capacity(departmentDTO.getTotalCapacity()));
    }
}
