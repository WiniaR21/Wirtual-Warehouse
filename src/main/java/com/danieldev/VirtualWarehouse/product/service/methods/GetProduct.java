package com.danieldev.VirtualWarehouse.product.service.methods;

import com.danieldev.VirtualWarehouse.product.product.Product;
import com.danieldev.VirtualWarehouse.product.product.ProductDTO;
import com.danieldev.VirtualWarehouse.utils.methods.FindProductById;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GetProduct {
    private final FindProductById findProductById;
    public ResponseEntity<ProductDTO> getProduct(Long productId) {
        Product product = findProductById.find(productId);

        return ResponseEntity.status(HttpStatus.OK).body(new ProductDTO(product));
    }
}
