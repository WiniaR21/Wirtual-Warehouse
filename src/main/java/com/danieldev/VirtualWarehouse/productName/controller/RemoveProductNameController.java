package com.danieldev.VirtualWarehouse.productName.controller;

import com.danieldev.VirtualWarehouse.productName.productName.ProductNameDTO;
import com.danieldev.VirtualWarehouse.productName.service.ProductNameService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/productNames/{productNameId}")
@RequiredArgsConstructor
public class RemoveProductNameController {
    private final ProductNameService adminProductNameService;

    @PreAuthorize("hasAnyAuthority('ADMIN') or hasAnyAuthority('MANAGER')")
    @DeleteMapping
    public ResponseEntity<ProductNameDTO> removeProductName
            (
            @PathVariable Long productNameId
            )
    {
        return adminProductNameService.removeProductName(productNameId);
    }
}
