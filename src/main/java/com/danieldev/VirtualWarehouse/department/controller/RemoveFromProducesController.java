package com.danieldev.VirtualWarehouse.department.controller;

import com.danieldev.VirtualWarehouse.department.department.DepartmentDTO;
import com.danieldev.VirtualWarehouse.department.service.DepartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/departments/{departmentId}/removeFromProduces")
@RequiredArgsConstructor
public class RemoveFromProducesController {
    private final DepartmentService departmentService;

    @PreAuthorize("hasAnyAuthority('ADMIN') or hasAnyAuthority('MANAGER')")
    @PutMapping
    public ResponseEntity<DepartmentDTO> removeFromProduces(
            @PathVariable Long departmentId,
            @RequestParam Long productNameId
    ) {
        return departmentService.removeFromProduces(departmentId, productNameId);
    }
}
