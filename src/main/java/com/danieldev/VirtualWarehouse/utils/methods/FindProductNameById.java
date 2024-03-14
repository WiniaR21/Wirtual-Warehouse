package com.danieldev.VirtualWarehouse.utils.methods;

import com.danieldev.VirtualWarehouse.productName.productName.ProductName;
import com.danieldev.VirtualWarehouse.exceptionHandler.exceptions.notFound.ProductNameNotFoundException;
import com.danieldev.VirtualWarehouse.productName.repository.ProductNameRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FindProductNameById {
    private final ProductNameRepository productNameRepository;

    public ProductName find(Long id){
        return productNameRepository.findById(id).orElseThrow(
                () -> new ProductNameNotFoundException(id)
        );
    }
}
