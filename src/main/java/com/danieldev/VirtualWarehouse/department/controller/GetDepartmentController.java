package com.danieldev.VirtualWarehouse.department.controller;

import com.danieldev.VirtualWarehouse.department.department.DepartmentDTO;
import com.danieldev.VirtualWarehouse.department.service.DepartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/departments")
@RequiredArgsConstructor
public class GetDepartmentController {
    private final DepartmentService departmentService;

    @PreAuthorize("hasAuthority('ADMIN') or hasAnyAuthority('MANAGER')")
    @GetMapping
    public ResponseEntity<List<DepartmentDTO>> getPackagingS()
    {
        return departmentService.getPackagingS();
    }

    @PreAuthorize("hasAuthority('ADMIN') or hasAnyAuthority('LIEDER') or hasAnyAuthority('MANAGER')")
    @GetMapping("/{departmentId}")
    public ResponseEntity<DepartmentDTO> getDepartment(
            @PathVariable Long departmentId
    )
    {
        return departmentService.getDepartment(departmentId);
    }
}
