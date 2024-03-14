package com.danieldev.VirtualWarehouse.product.controller;

import com.danieldev.VirtualWarehouse.product.response.ProductSumWeight;
import com.danieldev.VirtualWarehouse.product.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/v1/products/sumWeightByName")
@RequiredArgsConstructor
public class GetSumWeightByNameController {
    private final ProductService productService;

    @PreAuthorize("hasAnyAuthority('ADMIN') or hasAnyAuthority('MANAGER')")
    @GetMapping
    public ResponseEntity<ProductSumWeight> getSumWeightByName
            (
                    @RequestParam Long productNameId
            )
    {
        return productService.getSumWeightByName(productNameId);
    }
}
