package com.danieldev.VirtualWarehouse.productName.service.methods;

import com.danieldev.VirtualWarehouse.productName.productName.ProductNameDTO;
import com.danieldev.VirtualWarehouse.productName.repository.ProductNameRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class GetProductNames {
    private final ProductNameRepository productNameRepository;

    public ResponseEntity<List<ProductNameDTO>> getProductNames() {
        List<ProductNameDTO> productNameDTOList = new ArrayList<>();

        productNameRepository
                .findAll()
                .forEach(productName ->
                        productNameDTOList.add(new ProductNameDTO(productName,productName.getProducedByDepartment()))
                );

        return ResponseEntity.status(HttpStatus.OK).body(productNameDTOList);
    }
}
