package com.danieldev.VirtualWarehouse.product.service.methods;

import com.danieldev.VirtualWarehouse.product.repository.ProductRepository;
import com.danieldev.VirtualWarehouse.product.response.ProductSumWeight;
import com.danieldev.VirtualWarehouse.productName.productName.ProductName;
import com.danieldev.VirtualWarehouse.utils.methods.FindProductNameById;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
public class GetSumWeightByName {
    private final FindProductNameById findProductNameById;
    private final ProductRepository productRepository;
    public ResponseEntity<ProductSumWeight> getSumWeightByName(Long productNameId) {
        ProductName productName = findProductNameById.find(productNameId);

        BigDecimal netWeight = productRepository.getSumOfNetWeightByProductName(productName);
        BigDecimal grossWeight = productRepository.getSumOfGrossWeightByProductName(productName);


        ProductSumWeight productSumWeight = new ProductSumWeight();

        productSumWeight.setProductName(productName.getName().getValue());
        productSumWeight.setGrossWeight(grossWeight);
        productSumWeight.setNetWeight(netWeight);

        return ResponseEntity.status(HttpStatus.OK).body(productSumWeight);
    }
}
