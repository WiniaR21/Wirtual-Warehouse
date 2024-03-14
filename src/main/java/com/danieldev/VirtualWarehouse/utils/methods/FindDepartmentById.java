package com.danieldev.VirtualWarehouse.utils.methods;

import com.danieldev.VirtualWarehouse.department.department.Department;
import com.danieldev.VirtualWarehouse.exceptionHandler.exceptions.notFound.DepartmentNotFoundException;
import com.danieldev.VirtualWarehouse.department.repository.DepartmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FindDepartmentById {
    private final DepartmentRepository departmentRepository;

    public Department find(Long id){
        return departmentRepository.findById(id).orElseThrow(
                () -> new DepartmentNotFoundException(id)
        );
    }
}
