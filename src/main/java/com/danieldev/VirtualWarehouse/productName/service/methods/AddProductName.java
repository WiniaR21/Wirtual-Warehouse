package com.danieldev.VirtualWarehouse.productName.service.methods;

import com.danieldev.VirtualWarehouse.department.department.Department;
import com.danieldev.VirtualWarehouse.department.department.DepartmentsProductTypeManager;
import com.danieldev.VirtualWarehouse.productName.productName.ProductName;
import com.danieldev.VirtualWarehouse.productName.productName.ProductNameDTO;
import com.danieldev.VirtualWarehouse.exceptionHandler.exceptions.conflict.ProductNameAlredyExistException;
import com.danieldev.VirtualWarehouse.productName.repository.ProductNameRepository;
import com.danieldev.VirtualWarehouse.utils.methods.FindDepartmentById;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AddProductName {
    private final ProductNameRepository productNameRepository;
    private final FindDepartmentById findDepartmentById;
    private final DepartmentsProductTypeManager departmentsProductTypeManager;
    @Transactional
    public ResponseEntity<ProductNameDTO> addProductName(ProductNameDTO request, Long departmentId) {
        ProductName productName = new ProductName(request);
        Department department = findDepartmentById.find(departmentId);


        departmentsProductTypeManager.addProductType(department, productName);

        try {
            productNameRepository.save(productName);
        }
        catch (DataIntegrityViolationException e){
            throw new ProductNameAlredyExistException();
        }

        return ResponseEntity.status(HttpStatus.CREATED).body(new ProductNameDTO(productName, department));
    }
}
