package com.danieldev.VirtualWarehouse.productStatus.service.methods;

import com.danieldev.VirtualWarehouse.exceptionHandler.exceptions.conflict.RemoveProductStatusException;
import com.danieldev.VirtualWarehouse.product.repository.ProductRepository;
import com.danieldev.VirtualWarehouse.productStatus.productStatus.ProductStatus;
import com.danieldev.VirtualWarehouse.productStatus.productStatus.ProductStatusDTO;
import com.danieldev.VirtualWarehouse.productStatus.repository.ProductStatusRepository;
import com.danieldev.VirtualWarehouse.utils.methods.FindProductStatusById;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RemoveProductStatus {
    private final ProductStatusRepository productStatusRepository;
    private final FindProductStatusById findProductStatusById;
    private final ProductRepository productRepository;

    @Transactional
    public ResponseEntity<ProductStatusDTO> removeProductStatus(Long productStatusId) {
        ProductStatus productStatus = findProductStatusById.find(productStatusId);

        if(productRepository.existsByProductStatus(productStatus))
        {
            throw new RemoveProductStatusException(productStatusId);
        }
        else
        {
            productStatusRepository.delete(productStatus);
        }

        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
    }
}
