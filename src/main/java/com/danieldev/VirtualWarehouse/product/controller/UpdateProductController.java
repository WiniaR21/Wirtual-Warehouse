package com.danieldev.VirtualWarehouse.product.controller;

import com.danieldev.VirtualWarehouse.product.product.ProductDTO;
import com.danieldev.VirtualWarehouse.product.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/products/{productId}")
@RequiredArgsConstructor
public class UpdateProductController {
    private final ProductService productService;

    @PreAuthorize("hasAuthority('LIEDER') or hasAnyAuthority('ADMIN') or hasAnyAuthority('MANAGER')")
    @PutMapping
    public ResponseEntity<ProductDTO> updateProduct
            (
                    @RequestBody ProductDTO productDTO,
                    @PathVariable Long productId,
                    @RequestParam Long productNameId,
                    @RequestParam Long productStatusId,
                    @RequestParam Long packagingId
            )
            throws HttpMessageNotReadableException
    {
        return productService.updateProduct(productDTO, productId, productNameId, productStatusId, packagingId);
    }
}
