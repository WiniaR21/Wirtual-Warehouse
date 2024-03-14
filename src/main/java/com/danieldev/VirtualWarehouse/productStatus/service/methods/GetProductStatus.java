package com.danieldev.VirtualWarehouse.productStatus.service.methods;

import com.danieldev.VirtualWarehouse.productStatus.productStatus.ProductStatus;
import com.danieldev.VirtualWarehouse.productStatus.productStatus.ProductStatusDTO;
import com.danieldev.VirtualWarehouse.utils.methods.FindProductStatusById;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GetProductStatus {
    private final FindProductStatusById findProductStatusById;
    public ResponseEntity<ProductStatusDTO> getProductStatus(Long id) {
        ProductStatus productStatus = findProductStatusById.find(id);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(new ProductStatusDTO(productStatus));
    }
}
