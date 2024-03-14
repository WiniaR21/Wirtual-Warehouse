package com.danieldev.VirtualWarehouse.productStatus.controller;

import com.danieldev.VirtualWarehouse.productStatus.productStatus.ProductStatusDTO;
import com.danieldev.VirtualWarehouse.productStatus.service.ProductStatusService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/productStatuses/{productStatusId}")
@RequiredArgsConstructor
public class RemoveProductStatusController {
    private final ProductStatusService productStatusService;

    @PreAuthorize("hasAnyAuthority('ADMIN') or hasAnyAuthority('MANAGER')")
    @DeleteMapping
    public ResponseEntity<ProductStatusDTO> removeProductStatus
            (
            @PathVariable Long productStatusId
            )
    {
        return productStatusService.removeProductStatus(productStatusId);
    }
}
