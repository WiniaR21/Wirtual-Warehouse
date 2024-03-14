package com.danieldev.VirtualWarehouse.product.controller;

import com.danieldev.VirtualWarehouse.product.product.ProductDTO;
import com.danieldev.VirtualWarehouse.product.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/products")
@RequiredArgsConstructor
public class TransportProductController {
    private final ProductService productService;

    @PreAuthorize("hasAnyAuthority('ADMIN') or hasAnyAuthority('MANAGER')")
    @PutMapping("/{productId}/transport")
    public ResponseEntity<ProductDTO> transportProduct
            (
            @PathVariable Long productId,
            @RequestParam Long departmentId,
            @RequestParam(required = false) Long productStatusId
            )
    {
        return productService.transport(productId, departmentId, productStatusId);
    }
}
