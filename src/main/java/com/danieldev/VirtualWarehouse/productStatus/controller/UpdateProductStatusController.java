package com.danieldev.VirtualWarehouse.productStatus.controller;

import com.danieldev.VirtualWarehouse.productStatus.productStatus.ProductStatusDTO;
import com.danieldev.VirtualWarehouse.productStatus.service.ProductStatusService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/productStatuses/{productStatusId}")
@RequiredArgsConstructor
public class UpdateProductStatusController {
    private final ProductStatusService productStatusService;

    @PreAuthorize("hasAnyAuthority('ADMIN') or hasAnyAuthority('MANAGER')")
    @PutMapping
    public ResponseEntity<ProductStatusDTO> updateProductStatus
            (
            @PathVariable Long productStatusId,
            @RequestBody ProductStatusDTO request
            )
            throws HttpMessageNotReadableException
    {
        return productStatusService.updateProductStatus(productStatusId, request);
    }
}
