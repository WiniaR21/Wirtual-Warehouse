package com.danieldev.VirtualWarehouse.packaging.controller;

import com.danieldev.VirtualWarehouse.packaging.packaging.PackagingDTO;
import com.danieldev.VirtualWarehouse.packaging.service.PackagingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/packaging-s/{packagingId}")
@RequiredArgsConstructor
public class DeletePackagingController {
    private final PackagingService packagingService;

    @PreAuthorize("hasAuthority('ADMIN') or hasAnyAuthority('MANAGER')")
    @DeleteMapping
    public ResponseEntity<PackagingDTO> removePackaging
            (
            @PathVariable Long packagingId
            )
            throws HttpMessageNotReadableException
    {
        return packagingService.removePackaging(packagingId);
    }
}
