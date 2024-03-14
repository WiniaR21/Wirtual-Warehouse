package com.danieldev.VirtualWarehouse.packaging.controller;

import com.danieldev.VirtualWarehouse.packaging.packaging.PackagingDTO;
import com.danieldev.VirtualWarehouse.packaging.service.PackagingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/packaging-s/{packagingId}")
@RequiredArgsConstructor
public class UpdatePackagingController {
    private final PackagingService packagingService;

    @PreAuthorize("hasAnyAuthority('ADMIN') or hasAnyAuthority('MANAGER')")
    @PutMapping
    public ResponseEntity<PackagingDTO> updateProductName
            (
                    @PathVariable Long packagingId,
                    @RequestBody PackagingDTO request
            )
            throws HttpMessageNotReadableException
    {
        return packagingService.updatePackaging(packagingId, request);
    }
}
