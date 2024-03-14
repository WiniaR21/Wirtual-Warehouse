package com.danieldev.VirtualWarehouse.product.controller;

import com.danieldev.VirtualWarehouse.product.product.ProductDTO;
import com.danieldev.VirtualWarehouse.product.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/products/{productId}")
@RequiredArgsConstructor
public class DeleteProductController {
    private final ProductService productService;

    @PreAuthorize("hasAnyAuthority('ADMIN') or hasAnyAuthority('MANAGER')")
    @DeleteMapping
    public ResponseEntity<ProductDTO> deleteProduct
            (
            @PathVariable Long productId
            )
    {
        return productService.deleteProduct(productId);
    }
}
