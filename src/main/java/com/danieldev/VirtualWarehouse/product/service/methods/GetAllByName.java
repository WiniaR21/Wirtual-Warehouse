package com.danieldev.VirtualWarehouse.product.service.methods;

import com.danieldev.VirtualWarehouse.product.product.ProductDTO;
import com.danieldev.VirtualWarehouse.product.repository.ProductRepository;
import com.danieldev.VirtualWarehouse.productName.productName.ProductName;
import com.danieldev.VirtualWarehouse.utils.methods.FindProductNameById;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class GetAllByName {
    private final FindProductNameById findProductNameById;
    private final ProductRepository productRepository;

    public ResponseEntity<List<ProductDTO>> getAllByName(Long productNameId) {
        List<ProductDTO> productDTOS = new ArrayList<>();

        ProductName productName = findProductNameById.find(productNameId);

        productRepository.findAllByProductName(productName)
                .forEach(product -> productDTOS.add(new ProductDTO(product)));

        return ResponseEntity.status(HttpStatus.OK).body(productDTOS);
        
    }
}
