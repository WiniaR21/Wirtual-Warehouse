package com.danieldev.VirtualWarehouse.department.service.methods;

import com.danieldev.VirtualWarehouse.department.department.Department;
import com.danieldev.VirtualWarehouse.department.department.DepartmentDTO;
import com.danieldev.VirtualWarehouse.exceptionHandler.exceptions.conflict.DepartmentAlredyExistException;
import com.danieldev.VirtualWarehouse.department.repository.DepartmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AddDepartment {
    private final DepartmentRepository departmentRepository;
    public ResponseEntity<DepartmentDTO> addDepartment(DepartmentDTO request) {

        Department department = new Department(request);

        try {
            departmentRepository.save(department);
        }
        catch (DataIntegrityViolationException e){
            throw new DepartmentAlredyExistException();
        }

        return ResponseEntity.status(HttpStatus.CREATED).body(new DepartmentDTO(department));
    }
}
