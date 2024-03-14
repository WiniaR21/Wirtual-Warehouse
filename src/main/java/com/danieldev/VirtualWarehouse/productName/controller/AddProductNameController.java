package com.danieldev.VirtualWarehouse.productName.controller;

import com.danieldev.VirtualWarehouse.productName.productName.ProductNameDTO;
import com.danieldev.VirtualWarehouse.productName.service.ProductNameService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/productNames/add")
@RequiredArgsConstructor
public class AddProductNameController {
    private final ProductNameService productNameService;
    @PreAuthorize("hasAnyAuthority('ADMIN') or hasAnyAuthority('MANAGER')")
    @PostMapping
    public ResponseEntity<ProductNameDTO> addProductName
            (
            @RequestBody ProductNameDTO request,
            @RequestParam Long departmentId
            )
            throws HttpMessageNotReadableException
    {
        return productNameService.addProductName(request, departmentId);
    }
}
