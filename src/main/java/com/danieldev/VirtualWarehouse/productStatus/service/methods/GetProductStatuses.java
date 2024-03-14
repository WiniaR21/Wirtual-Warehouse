package com.danieldev.VirtualWarehouse.productStatus.service.methods;

import com.danieldev.VirtualWarehouse.productStatus.productStatus.ProductStatusDTO;
import com.danieldev.VirtualWarehouse.productStatus.repository.ProductStatusRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class GetProductStatuses {
    private final ProductStatusRepository productStatusRepository;

    public ResponseEntity<List<ProductStatusDTO>> getProductStatuses() {
        List<ProductStatusDTO> productStatusDTOList = new ArrayList<>();

        productStatusRepository
                .findAll()
                .forEach(productStatus -> productStatusDTOList.add(new ProductStatusDTO(productStatus)));

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(productStatusDTOList);
    }
}
