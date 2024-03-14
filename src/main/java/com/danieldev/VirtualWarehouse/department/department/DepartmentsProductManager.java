package com.danieldev.VirtualWarehouse.department.department;

import com.danieldev.VirtualWarehouse.exceptionHandler.exceptions.conflict.DepartmentAlreadyContainProductException;
import com.danieldev.VirtualWarehouse.exceptionHandler.exceptions.conflict.RemoveProductFromDepartmentException;
import com.danieldev.VirtualWarehouse.product.product.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DepartmentsProductManager {
    //  addProduct adds product to products list in department also,
    //  sets this department in this product
    public void addProduct(Department department, Product product){
        if (department.getProducts().contains(product)){
            throw new DepartmentAlreadyContainProductException(product.getId(), department.getId());
        }
        else {
            product.setDepartment(department);
            department.getCapacity().lowerCurrentCapacity(product.getCapacity());
            department.getProducts().add(product);
        }
    }
    //  removeProduct removes product from products list in department also,
    //  removes department from this product
    public void removeProduct(Department department, Product product){
        if(!department.getProducts().contains(product)){
            throw new RemoveProductFromDepartmentException(product.getId(), department.getId());
        }
        else {
            department.getCapacity().increaseCurrentCapacity(product.getCapacity());
            department.getProducts().remove(product);
        }
    }
}
