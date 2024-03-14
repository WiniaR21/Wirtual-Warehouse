package com.danieldev.VirtualWarehouse.productName.controller;

import com.danieldev.VirtualWarehouse.productName.productName.ProductNameDTO;
import com.danieldev.VirtualWarehouse.productName.service.ProductNameService;
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
@RequestMapping("/api/v1/productNames")
@RequiredArgsConstructor
public class GetProductNameController {
    private final ProductNameService adminProductNameService;

    @GetMapping
    public ResponseEntity<List<ProductNameDTO>> getProductNames()
    {
        return adminProductNameService.getProductNames();
    }

    @GetMapping("{productNameId}")
    public ResponseEntity<ProductNameDTO> getProductName
            (
            @PathVariable Long productNameId
            )
    {
        return adminProductNameService.getProductName(productNameId);
    }
}
