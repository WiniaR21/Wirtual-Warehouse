package com.danieldev.VirtualWarehouse.product.service.methods;

import com.danieldev.VirtualWarehouse.product.product.ProductDTO;
import com.danieldev.VirtualWarehouse.product.repository.ProductRepository;
import com.danieldev.VirtualWarehouse.productName.productName.ProductName;
import com.danieldev.VirtualWarehouse.productStatus.productStatus.ProductStatus;
import com.danieldev.VirtualWarehouse.utils.methods.FindProductNameById;
import com.danieldev.VirtualWarehouse.utils.methods.FindProductStatusById;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
@RequiredArgsConstructor
public class GetAllByStatusAndName {
    private final ProductRepository productRepository;
    private final FindProductStatusById findProductStatusById;
    private final FindProductNameById findProductNameById;

    public ResponseEntity<List<ProductDTO>> getAllByStatusAndName(Long statusId, Long productNameId) {
        List<ProductDTO> productDTOS = new ArrayList<>();

        ProductStatus productStatus = findProductStatusById.find(statusId);
        ProductName productName = findProductNameById.find(productNameId);

        productRepository.findAllByProductNameAndProductStatus(productName,productStatus)
                .forEach(product -> productDTOS.add(new ProductDTO(product)));

        return ResponseEntity.ok().body(productDTOS);
    }
}
