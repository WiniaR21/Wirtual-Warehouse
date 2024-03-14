package com.danieldev.VirtualWarehouse.department.service.methods;

import com.danieldev.VirtualWarehouse.department.department.Department;
import com.danieldev.VirtualWarehouse.department.repository.DepartmentRepository;
import com.danieldev.VirtualWarehouse.exceptionHandler.exceptions.conflict.RemoveDepartmentException;
import com.danieldev.VirtualWarehouse.packaging.packaging.PackagingDTO;
import com.danieldev.VirtualWarehouse.utils.methods.FindDepartmentById;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RemoveDepartment {
    private final FindDepartmentById findDepartmentById;
    private final DepartmentRepository departmentRepository;

    public ResponseEntity<PackagingDTO> removeDepartment(Long departmentId) {
        Department department = findDepartmentById.find(departmentId);

        if (!department.getProducts().isEmpty()){
            throw new RemoveDepartmentException(departmentId);
        }
        else {
            departmentRepository.delete(department);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
        }
    }
}
