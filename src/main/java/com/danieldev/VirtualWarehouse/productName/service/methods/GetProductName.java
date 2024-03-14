package com.danieldev.VirtualWarehouse.productName.service.methods;

import com.danieldev.VirtualWarehouse.productName.productName.ProductName;
import com.danieldev.VirtualWarehouse.productName.productName.ProductNameDTO;
import com.danieldev.VirtualWarehouse.utils.methods.FindProductNameById;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GetProductName {
    private final FindProductNameById findProductNameById;

    public ResponseEntity<ProductNameDTO> getProductName(Long id) {
        ProductName productName = findProductNameById.find(id);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(new ProductNameDTO(productName, productName.getProducedByDepartment()));
    }
}
