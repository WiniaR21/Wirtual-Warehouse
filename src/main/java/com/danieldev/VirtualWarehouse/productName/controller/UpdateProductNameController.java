package com.danieldev.VirtualWarehouse.productName.controller;

import com.danieldev.VirtualWarehouse.productName.productName.ProductNameDTO;
import com.danieldev.VirtualWarehouse.productName.service.ProductNameService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/productNames/{productNameId}")
@RequiredArgsConstructor
public class UpdateProductNameController {
    private final ProductNameService adminProductNameService;

    @PreAuthorize("hasAnyAuthority('ADMIN') or hasAnyAuthority('MANAGER')")
    @PutMapping
    public ResponseEntity<ProductNameDTO> updateProductName
            (
            @PathVariable Long productNameId,
            @RequestBody ProductNameDTO request
            )
            throws HttpMessageNotReadableException
    {
        return adminProductNameService.updateProductName(productNameId, request);
    }
}
