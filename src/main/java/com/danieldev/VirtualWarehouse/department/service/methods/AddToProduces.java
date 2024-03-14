package com.danieldev.VirtualWarehouse.department.service.methods;

import com.danieldev.VirtualWarehouse.department.department.Department;
import com.danieldev.VirtualWarehouse.department.department.DepartmentDTO;
import com.danieldev.VirtualWarehouse.department.department.DepartmentsProductTypeManager;
import com.danieldev.VirtualWarehouse.productName.productName.ProductName;
import com.danieldev.VirtualWarehouse.department.repository.DepartmentRepository;
import com.danieldev.VirtualWarehouse.utils.methods.FindDepartmentById;
import com.danieldev.VirtualWarehouse.utils.methods.FindProductNameById;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AddToProduces {
    private final FindDepartmentById findDepartmentById;
    private final FindProductNameById findProductNameById;
    private final DepartmentRepository departmentRepository;

    private final DepartmentsProductTypeManager departmentsProductTypeManager;
    public ResponseEntity<DepartmentDTO> addToProduces(Long departmentId, Long productNameId) {
        Department department = findDepartmentById.find(departmentId);
        ProductName productName = findProductNameById.find(productNameId);

        departmentsProductTypeManager.addProductType(department, productName);
        departmentRepository.save(department);

        return ResponseEntity.status(HttpStatus.OK).body(new DepartmentDTO(department));
    }
}
