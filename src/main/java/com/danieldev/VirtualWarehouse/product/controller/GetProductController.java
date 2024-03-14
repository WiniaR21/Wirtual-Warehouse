package com.danieldev.VirtualWarehouse.product.controller;

import com.danieldev.VirtualWarehouse.product.product.ProductDTO;
import com.danieldev.VirtualWarehouse.product.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
@RequiredArgsConstructor
public class GetProductController {
    private final ProductService productService;

    @GetMapping
    public ResponseEntity<List<ProductDTO>> getProduct()
    {
        return productService.getProducts();
    }

    @PreAuthorize("hasAuthority('LIEDER') or hasAnyAuthority('ADMIN') or hasAnyAuthority('MANAGER')")
    @GetMapping("/{productId}")
    public ResponseEntity<ProductDTO> getProduct
            (
                    @PathVariable Long productId
            )
    {
        return productService.getProduct(productId);
    }
}
