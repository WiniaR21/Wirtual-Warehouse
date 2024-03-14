package com.danieldev.VirtualWarehouse.product.service.methods;

import com.danieldev.VirtualWarehouse.product.product.ProductDTO;
import com.danieldev.VirtualWarehouse.product.repository.ProductRepository;
import com.danieldev.VirtualWarehouse.productStatus.productStatus.ProductStatus;
import com.danieldev.VirtualWarehouse.utils.methods.FindProductStatusById;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class GetAllByStatus {
    private final ProductRepository productRepository;
    private final FindProductStatusById findProductStatusById;

    public ResponseEntity<List<ProductDTO>> getAllByStatus(Long statusId) {
        List<ProductDTO> productDTOS = new ArrayList<>();
        ProductStatus productStatus = findProductStatusById.find(statusId);

        productRepository.findAllByProductStatus(productStatus).forEach(product -> productDTOS.add(new ProductDTO(product)));

        return ResponseEntity.ok().body(productDTOS);
    }
}
