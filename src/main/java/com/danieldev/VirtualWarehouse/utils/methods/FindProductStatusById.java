package com.danieldev.VirtualWarehouse.utils.methods;

import com.danieldev.VirtualWarehouse.productStatus.productStatus.ProductStatus;
import com.danieldev.VirtualWarehouse.exceptionHandler.exceptions.notFound.ProductStatusNotFoundException;
import com.danieldev.VirtualWarehouse.productStatus.repository.ProductStatusRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FindProductStatusById {
    private final ProductStatusRepository productStatusRepository;

    public ProductStatus find(Long id){
        return productStatusRepository.findById(id).orElseThrow(
                () -> new ProductStatusNotFoundException(id)
        );
    }
}
