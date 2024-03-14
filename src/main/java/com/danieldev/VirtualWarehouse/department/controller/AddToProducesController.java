package com.danieldev.VirtualWarehouse.department.controller;

import com.danieldev.VirtualWarehouse.department.department.DepartmentDTO;
import com.danieldev.VirtualWarehouse.department.service.DepartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/departments/{departmentId}/addToProduces")
@RequiredArgsConstructor
public class AddToProducesController {
    private final DepartmentService departmentService;

    @PreAuthorize("hasAnyAuthority('ADMIN') or hasAnyAuthority('MANAGER')")
    @PutMapping()
    public ResponseEntity<DepartmentDTO> addToProduces(
            @PathVariable Long departmentId,
            @RequestParam Long productNameId
    ) {
        return departmentService.addToProduces(departmentId, productNameId);
    }
}
