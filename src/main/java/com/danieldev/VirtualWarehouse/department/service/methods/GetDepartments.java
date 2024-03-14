package com.danieldev.VirtualWarehouse.department.service.methods;

import com.danieldev.VirtualWarehouse.department.department.DepartmentDTO;
import com.danieldev.VirtualWarehouse.department.repository.DepartmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class GetDepartments {
    private final DepartmentRepository departmentRepository;

    public ResponseEntity<List<DepartmentDTO>> getDepartments() {
        List<DepartmentDTO> departmentDTOList = new ArrayList<>();

        departmentRepository.findAll().forEach(department -> departmentDTOList.add(new DepartmentDTO(department)));

        return ResponseEntity.status(HttpStatus.OK).body(departmentDTOList);
    }
}
