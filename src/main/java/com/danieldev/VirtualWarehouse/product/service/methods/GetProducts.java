package com.danieldev.VirtualWarehouse.product.service.methods;

import com.danieldev.VirtualWarehouse.product.product.ProductDTO;
import com.danieldev.VirtualWarehouse.product.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class GetProducts {
    private final ProductRepository productRepository;

    public ResponseEntity<List<ProductDTO>> getProducts() {
        List<ProductDTO> productDTOS = new ArrayList<>();
        productRepository.findAll().forEach(product -> productDTOS.add(new ProductDTO(product)));
        return ResponseEntity.status(HttpStatus.OK).body(productDTOS);
    }
}
