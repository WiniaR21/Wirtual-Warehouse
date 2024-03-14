package com.danieldev.VirtualWarehouse.productStatus.service.methods;

import com.danieldev.VirtualWarehouse.utils.fields.Name;
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
public class UpdateProductStatus {
    private final ProductStatusRepository productStatusRepository;
    private final FindProductStatusById findProductStatusById;

    @Transactional
    public ResponseEntity<ProductStatusDTO> updateProductStatus(Long id, ProductStatusDTO request) {
        ProductStatus productStatus = findProductStatusById.find(id);

        productStatus.setName(
                new Name(request.getStatusName())
        );

        productStatusRepository.save(productStatus);

        return ResponseEntity.status(HttpStatus.OK).body(new ProductStatusDTO(productStatus));
    }
}
