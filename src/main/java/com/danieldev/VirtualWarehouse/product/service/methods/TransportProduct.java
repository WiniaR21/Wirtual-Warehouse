package com.danieldev.VirtualWarehouse.product.service.methods;

import com.danieldev.VirtualWarehouse.department.department.Department;
import com.danieldev.VirtualWarehouse.department.department.DepartmentsProductManager;
import com.danieldev.VirtualWarehouse.exceptionHandler.exceptions.conflict.TransportConflictException;
import com.danieldev.VirtualWarehouse.product.product.Product;
import com.danieldev.VirtualWarehouse.product.product.ProductDTO;
import com.danieldev.VirtualWarehouse.product.repository.ProductRepository;
import com.danieldev.VirtualWarehouse.productStatus.productStatus.ProductStatus;
import com.danieldev.VirtualWarehouse.utils.methods.FindDepartmentById;
import com.danieldev.VirtualWarehouse.utils.methods.FindProductById;
import com.danieldev.VirtualWarehouse.utils.methods.FindProductStatusById;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TransportProduct {
    private final FindProductById findProductById;
    private final FindDepartmentById findDepartmentById;
    private final ProductRepository productRepository;
    private final FindProductStatusById findProductStatusById;

    private final DepartmentsProductManager departmentsProductManager;

    public ResponseEntity<ProductDTO> transportProduct(Long productId, Long departmentId, Long productStatusId) {
        Product product = findProductById.find(productId);
        Department department = findDepartmentById.find(departmentId);


        //  Case where user want transport product to same department
        if(product.getDepartment() == department){
            throw new TransportConflictException(departmentId, departmentId);
        }
        else {
            if (productStatusId != null){
                ProductStatus productStatus = findProductStatusById.find(productStatusId);
                product.setProductStatus(productStatus);
            }

            departmentsProductManager.removeProduct(product.getDepartment(), product);
            departmentsProductManager.addProduct(department,product);
        }


        productRepository.save(product);
        return ResponseEntity.status(HttpStatus.OK).body(new ProductDTO(product));
    }
}
