package com.danieldev.VirtualWarehouse.packaging.controller;

import com.danieldev.VirtualWarehouse.packaging.packaging.PackagingDTO;
import com.danieldev.VirtualWarehouse.packaging.service.PackagingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/packaging-s/add")
@RequiredArgsConstructor
public class AddPackagingController {
    private final PackagingService packagingService;

    @PreAuthorize("hasAuthority('ADMIN') or hasAnyAuthority('MANAGER')")
    @PostMapping
    public ResponseEntity<PackagingDTO> addPackaging
            (
            @RequestBody PackagingDTO request
            )
            throws HttpMessageNotReadableException
    {
        return packagingService.addPackaging(request);
    }
}
