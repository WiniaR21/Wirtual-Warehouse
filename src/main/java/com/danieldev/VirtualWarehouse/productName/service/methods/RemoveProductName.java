package com.danieldev.VirtualWarehouse.productName.service.methods;

import com.danieldev.VirtualWarehouse.exceptionHandler.exceptions.conflict.RemoveProductNameException;
import com.danieldev.VirtualWarehouse.product.repository.ProductRepository;
import com.danieldev.VirtualWarehouse.productName.productName.ProductName;
import com.danieldev.VirtualWarehouse.productName.productName.ProductNameDTO;
import com.danieldev.VirtualWarehouse.productName.repository.ProductNameRepository;
import com.danieldev.VirtualWarehouse.utils.methods.FindProductNameById;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RemoveProductName {
    private final ProductNameRepository productNameRepository;
    private final ProductRepository productRepository;
    private final FindProductNameById findProductNameById;
    @Transactional
    public ResponseEntity<ProductNameDTO> removeProductName(Long productNameId) {
        ProductName productName = findProductNameById.find(productNameId);

        if(productRepository.existsByProductName(productName))
        {
            throw new RemoveProductNameException(productNameId);
        }
        else
        {
            productNameRepository.delete(productName);

        }

        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
    }
}
