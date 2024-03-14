package com.danieldev.VirtualWarehouse.department.controller;

import com.danieldev.VirtualWarehouse.department.service.DepartmentService;
import com.danieldev.VirtualWarehouse.packaging.packaging.PackagingDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/departments/{departmentId}")
@RequiredArgsConstructor
public class DeleteDepartmentController {
    private final DepartmentService departmentService;

    @PreAuthorize("hasAuthority('ADMIN')")
    @DeleteMapping
    public ResponseEntity<PackagingDTO> removeDepartment
            (
                    @PathVariable Long departmentId
            )
    {
        return departmentService.removeDepartment(departmentId);
    }
}
