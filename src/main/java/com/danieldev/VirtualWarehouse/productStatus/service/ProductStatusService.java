package com.danieldev.VirtualWarehouse.productStatus.service;

import com.danieldev.VirtualWarehouse.productStatus.productStatus.ProductStatusDTO;
import com.danieldev.VirtualWarehouse.productStatus.service.methods.AddProductStatus;
import com.danieldev.VirtualWarehouse.productStatus.service.methods.GetProductStatuses;
import com.danieldev.VirtualWarehouse.productStatus.service.methods.UpdateProductStatus;
import com.danieldev.VirtualWarehouse.productStatus.service.methods.RemoveProductStatus;
import com.danieldev.VirtualWarehouse.productStatus.service.methods.GetProductStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductStatusService {
    private final AddProductStatus addProductStatus;
    private final RemoveProductStatus removeProductStatus;
    private final UpdateProductStatus updateProductStatus;
    private final GetProductStatus getProductStatus;
    private final GetProductStatuses getProductStatuses;

    public ResponseEntity<ProductStatusDTO> getProductStatus(Long id) {
        return getProductStatus.getProductStatus(id);
    }

    public ResponseEntity<List<ProductStatusDTO>> getProductStatuses() {
        return getProductStatuses.getProductStatuses();
    }
    public ResponseEntity<ProductStatusDTO> addProductStatus(ProductStatusDTO request) {
        return addProductStatus.addProductStatus(request);
    }

    public ResponseEntity<ProductStatusDTO> removeProductStatus(Long id) {
        return removeProductStatus.removeProductStatus(id);
    }

    public ResponseEntity<ProductStatusDTO> updateProductStatus(Long id, ProductStatusDTO request) {
        return updateProductStatus.updateProductStatus(id, request);
    }
}
