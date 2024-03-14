package com.danieldev.VirtualWarehouse.department.service.methods;

import com.danieldev.VirtualWarehouse.department.department.Department;
import com.danieldev.VirtualWarehouse.department.department.DepartmentDTO;
import com.danieldev.VirtualWarehouse.utils.methods.FindDepartmentById;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GetDepartment {
    private final FindDepartmentById findDepartmentById;

    public ResponseEntity<DepartmentDTO> getDepartment(Long id) {
        Department department = findDepartmentById.find(id);
        return ResponseEntity.status(HttpStatus.OK).body(new DepartmentDTO(department));
    }
}
