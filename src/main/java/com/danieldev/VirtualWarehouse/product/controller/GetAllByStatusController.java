package com.danieldev.VirtualWarehouse.product.controller;

import com.danieldev.VirtualWarehouse.product.product.ProductDTO;
import com.danieldev.VirtualWarehouse.product.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
@RequestMapping("/api/v1/products/allByStatus")
@RequiredArgsConstructor
public class GetAllByStatusController {

        private final ProductService productService;
        @PreAuthorize("hasAnyAuthority('ADMIN') or hasAnyAuthority('MANAGER')")
        @GetMapping
        public ResponseEntity<List<ProductDTO>> getAllByStatus
                (
                        @RequestParam Long statusId
                )
        {
            return productService.getAllByStatus(statusId);
        }
}
