package com.danieldev.VirtualWarehouse.packaging.controller;

import com.danieldev.VirtualWarehouse.packaging.packaging.PackagingDTO;
import com.danieldev.VirtualWarehouse.packaging.service.PackagingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@PreAuthorize("hasAuthority('LIEDER') or hasAnyAuthority('ADMIN') or hasAnyAuthority('MANAGER')")
@RestController
@RequestMapping("/api/v1/packaging-s")
@RequiredArgsConstructor
public class GetPackagingController {
    private final PackagingService packagingService;


    @GetMapping
    public ResponseEntity<List<PackagingDTO>> getPackagingS()
    {
        return packagingService.getPackagingS();
    }

    @GetMapping("/{id}")
    public ResponseEntity<PackagingDTO> getPackaging
            (
            @PathVariable Long id
            )
    {
        return packagingService.getPackaging(id);
    }
}
