package com.danieldev.VirtualWarehouse.product.service.methods;

import com.danieldev.VirtualWarehouse.department.department.Department;
import com.danieldev.VirtualWarehouse.department.department.DepartmentsProductManager;
import com.danieldev.VirtualWarehouse.packaging.packaging.Packaging;
import com.danieldev.VirtualWarehouse.product.product.Product;
import com.danieldev.VirtualWarehouse.product.product.ProductDTO;
import com.danieldev.VirtualWarehouse.productName.productName.ProductName;
import com.danieldev.VirtualWarehouse.productStatus.productStatus.ProductStatus;
import com.danieldev.VirtualWarehouse.product.repository.ProductRepository;
import com.danieldev.VirtualWarehouse.utils.methods.FindDepartmentById;
import com.danieldev.VirtualWarehouse.utils.methods.FindPackagingById;
import com.danieldev.VirtualWarehouse.utils.methods.FindProductNameById;
import com.danieldev.VirtualWarehouse.utils.methods.FindProductStatusById;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AddProduct {
    private final FindDepartmentById findDepartmentById;
    private final FindProductNameById findProductNameById;
    private final FindProductStatusById findProductStatusById;
    private final FindPackagingById findPackagingById;

    private final ProductRepository productRepository;

    private final DepartmentsProductManager departmentsProductManager;
    public ResponseEntity<ProductDTO> addProduct(
            ProductDTO productDTO,
            Long departmentId,
            Long productNameId,
            Long productStatusId,
            Long packagingId
    ) {
        Department department = findDepartmentById.find(departmentId);
        ProductName productName = findProductNameById.find(productNameId);
        ProductStatus productStatus = findProductStatusById.find(productStatusId);
        Packaging packaging = findPackagingById.find(packagingId);

        Product product = new Product(
                productDTO,
                productName,
                department,
                productStatus,
                packaging
        );

        departmentsProductManager.addProduct(department, product);
        productRepository.save(product);

        return ResponseEntity.status(HttpStatus.CREATED).body(new ProductDTO(product));
    }
}
