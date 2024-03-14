package com.danieldev.VirtualWarehouse.department.controller;

import com.danieldev.VirtualWarehouse.department.department.DepartmentDTO;
import com.danieldev.VirtualWarehouse.department.service.DepartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/departments/addDepartment")
@RequiredArgsConstructor
public class AddDepartmentController {
    private final DepartmentService departmentService;

    @PreAuthorize(value = "hasAnyAuthority('ADMIN') OR hasAnyAuthority('MANAGER')")
    @PostMapping
    public ResponseEntity<DepartmentDTO> addDepartment(
            @RequestBody DepartmentDTO request
    ) throws HttpMessageNotReadableException {
        return departmentService.addDepartment(request);
    }
}
