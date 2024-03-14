package com.danieldev.VirtualWarehouse.product.controller;

import com.danieldev.VirtualWarehouse.product.product.ProductDTO;
import com.danieldev.VirtualWarehouse.product.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/products/allByName")
@RequiredArgsConstructor
public class GetAllByNameController {
    private final ProductService productService;

    @PreAuthorize("hasAnyAuthority('ADMIN') or hasAnyAuthority('MANAGER')")
    @GetMapping
    public ResponseEntity<List<ProductDTO>> getAllByName
            (
                    @RequestParam Long productNameId
            )
    {
        return productService.getAllByName(productNameId);
    }
}
