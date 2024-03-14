package com.danieldev.VirtualWarehouse.productName.service;

import com.danieldev.VirtualWarehouse.productName.productName.ProductNameDTO;
import com.danieldev.VirtualWarehouse.productName.service.methods.AddProductName;
import com.danieldev.VirtualWarehouse.productName.service.methods.GetProductName;
import com.danieldev.VirtualWarehouse.productName.service.methods.GetProductNames;
import com.danieldev.VirtualWarehouse.productName.service.methods.RemoveProductName;
import com.danieldev.VirtualWarehouse.productName.service.methods.UpdateProductName;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductNameService {
    private final AddProductName addProductName;
    private final RemoveProductName removeProductName;
    private final UpdateProductName updateProductName;
    private final GetProductName getProductName;
    private final GetProductNames getProductNames;
    public ResponseEntity<ProductNameDTO> getProductName(Long id) {
        return getProductName.getProductName(id);
    }

    public ResponseEntity<List<ProductNameDTO>> getProductNames() {
        return getProductNames.getProductNames();
    }

    public ResponseEntity<ProductNameDTO> addProductName(ProductNameDTO request, Long departmentId){
        return addProductName.addProductName(request, departmentId);
    }
    public ResponseEntity<ProductNameDTO> removeProductName(Long id) {
        return removeProductName.removeProductName(id);
    }

    public ResponseEntity<ProductNameDTO> updateProductName(Long id, ProductNameDTO request) {
        return updateProductName.updateProductName(id, request);
    }
}
