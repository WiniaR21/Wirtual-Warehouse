package com.danieldev.VirtualWarehouse.product.controller;

import com.danieldev.VirtualWarehouse.product.product.ProductDTO;
import com.danieldev.VirtualWarehouse.product.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/products/addProduct")
@RequiredArgsConstructor
public class AddProductController {
    private final ProductService productService;

    @PreAuthorize("hasAuthority('LIEDER') or hasAnyAuthority('ADMIN') or hasAnyAuthority('MANAGER')")
    @PostMapping
    public ResponseEntity<ProductDTO> addProduct
            (
            @RequestParam Long departmentId,
            @RequestParam Long productNameId,
            @RequestParam Long productStatusId,
            @RequestParam Long packagingId,
            @RequestBody ProductDTO productDTO
            )
            throws HttpMessageNotReadableException
    {
        return productService.addProduct(productDTO, departmentId, productNameId, productStatusId, packagingId);
    }
}
