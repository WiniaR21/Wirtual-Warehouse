package com.danieldev.VirtualWarehouse.utils.methods;

import com.danieldev.VirtualWarehouse.product.product.Product;
import com.danieldev.VirtualWarehouse.exceptionHandler.exceptions.notFound.ProductNotFoundException;
import com.danieldev.VirtualWarehouse.product.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FindProductById {
    private final ProductRepository productRepository;

    public Product find(Long id){
        return productRepository.findById(id).orElseThrow(
                () ->  new ProductNotFoundException(id)
        );
    }
}
