package com.danieldev.VirtualWarehouse.product.service.methods;

import com.danieldev.VirtualWarehouse.department.department.DepartmentsProductManager;
import com.danieldev.VirtualWarehouse.product.product.Product;
import com.danieldev.VirtualWarehouse.product.product.ProductDTO;
import com.danieldev.VirtualWarehouse.product.repository.ProductRepository;
import com.danieldev.VirtualWarehouse.utils.methods.FindProductById;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DeleteProduct {
    private final FindProductById findProductById;
    private final ProductRepository productRepository;

    private final DepartmentsProductManager departmentsProductManager;

    @Transactional
    public ResponseEntity<ProductDTO> deleteProduct(Long productId) {
        Product product = findProductById.find(productId);

        departmentsProductManager.removeProduct(
                product.getDepartment(),
                product
        );

        productRepository.delete(product);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
    }
}
