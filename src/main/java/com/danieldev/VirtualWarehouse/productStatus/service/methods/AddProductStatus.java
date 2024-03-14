package com.danieldev.VirtualWarehouse.productStatus.service.methods;

import com.danieldev.VirtualWarehouse.productStatus.productStatus.ProductStatus;
import com.danieldev.VirtualWarehouse.productStatus.productStatus.ProductStatusDTO;
import com.danieldev.VirtualWarehouse.exceptionHandler.exceptions.conflict.ProductStatusAlredyExistException;
import com.danieldev.VirtualWarehouse.productStatus.repository.ProductStatusRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AddProductStatus {
    private final ProductStatusRepository productStatusRepository;

    @Transactional
    public ResponseEntity<ProductStatusDTO> addProductStatus(ProductStatusDTO request) {
        ProductStatus productStatus = new ProductStatus(request);

        try {
            productStatusRepository.save(productStatus);
        }
        catch (DataIntegrityViolationException e){
            throw new ProductStatusAlredyExistException();
        }

        return ResponseEntity.status(HttpStatus.CREATED).body(new ProductStatusDTO(productStatus));
    }
}
