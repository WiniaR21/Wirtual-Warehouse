package com.danieldev.VirtualWarehouse.department.department;

import com.danieldev.VirtualWarehouse.exceptionHandler.exceptions.conflict.AddToProducesException;
import com.danieldev.VirtualWarehouse.exceptionHandler.exceptions.notFound.RemoveFromProducesException;
import com.danieldev.VirtualWarehouse.productName.productName.ProductName;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DepartmentsProductTypeManager {
    //  addProductType adds product type to produces list in department,
    //  also sets this department in product type
    public void addProductType(Department department, ProductName productName){
        if(department.getProduces().contains(productName)){
            throw new AddToProducesException(department.getId(), productName.getId());
        }
        else {
            productName.setProducedByDepartment(department);
            department.getProduces().add(productName);
        }
    }
    //  removeProductType removes product type from produces list in department,
    //  also removes this department from product type
    public void removeProductType(Department department, ProductName productName){
        if(!department.getProduces().contains(productName)){
            throw new RemoveFromProducesException(department.getId(), productName.getId());
        }
        else {
            productName.setProducedByDepartment(null);
            department.getProduces().remove(productName);
        }
    }
}
