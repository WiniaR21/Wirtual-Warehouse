package com.danieldev.VirtualWarehouse.productName.service.methods;

import com.danieldev.VirtualWarehouse.utils.fields.Name;
import com.danieldev.VirtualWarehouse.productName.productName.ProductName;
import com.danieldev.VirtualWarehouse.productName.productName.ProductNameDTO;
import com.danieldev.VirtualWarehouse.productName.repository.ProductNameRepository;
import com.danieldev.VirtualWarehouse.utils.methods.FindProductNameById;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UpdateProductName {
    private final ProductNameRepository productNameRepository;
    private final FindProductNameById findProductNameById;
    public ResponseEntity<ProductNameDTO> updateProductName(Long id, ProductNameDTO request) {
        ProductName productName = findProductNameById.find(id);

        productName.setName(new Name(request.getProductName()));

        productNameRepository.save(productName);

        return ResponseEntity.status(HttpStatus.OK).body(new ProductNameDTO(productName, productName.getProducedByDepartment()));
    }
}
