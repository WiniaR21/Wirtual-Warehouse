package com.danieldev.VirtualWarehouse.productStatus.controller;

import com.danieldev.VirtualWarehouse.productStatus.productStatus.ProductStatusDTO;
import com.danieldev.VirtualWarehouse.productStatus.service.ProductStatusService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/productStatuses/add")
@RequiredArgsConstructor
public class AddProductStatusController {
    private final ProductStatusService productStatusService;

    @PreAuthorize("hasAnyAuthority('ADMIN') or hasAnyAuthority('MANAGER')")
    @PostMapping
    public ResponseEntity<ProductStatusDTO> addProductStatus
            (
            @RequestBody ProductStatusDTO request
            )
            throws HttpMessageNotReadableException
    {
        return productStatusService.addProductStatus(request);
    }
}
