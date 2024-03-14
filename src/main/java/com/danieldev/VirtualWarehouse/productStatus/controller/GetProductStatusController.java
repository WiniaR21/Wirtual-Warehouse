package com.danieldev.VirtualWarehouse.productStatus.controller;

import com.danieldev.VirtualWarehouse.productStatus.productStatus.ProductStatusDTO;
import com.danieldev.VirtualWarehouse.productStatus.service.ProductStatusService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@PreAuthorize("hasAuthority('LIEDER') or hasAnyAuthority('ADMIN') or hasAnyAuthority('MANAGER')")
@RestController
@RequestMapping("/api/v1/productStatuses")
@RequiredArgsConstructor
public class GetProductStatusController {
    private final ProductStatusService productStatusService;

    @GetMapping
    public ResponseEntity<List<ProductStatusDTO>> getProductStatuses()
    {
        return productStatusService.getProductStatuses();
    }

    @GetMapping("{productStatusId}")
    public ResponseEntity<ProductStatusDTO> getProductStatus
            (
            @PathVariable Long productStatusId
            )
    {
        return productStatusService.getProductStatus(productStatusId);
    }
}
