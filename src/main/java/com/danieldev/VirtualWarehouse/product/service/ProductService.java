package com.danieldev.VirtualWarehouse.product.service;

import com.danieldev.VirtualWarehouse.product.product.ProductDTO;
import com.danieldev.VirtualWarehouse.product.response.ProductSumWeight;
import com.danieldev.VirtualWarehouse.product.service.methods.GetAllByStatus;
import com.danieldev.VirtualWarehouse.product.service.methods.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final AddProduct addProduct;
    private final GetProduct getProduct;
    private final GetProducts getProducts;
    private final DeleteProduct deleteProduct;
    private final TransportProduct transportProduct;
    private final UpdateProduct updateProduct;
    private final GetAllByName getAllByName;
    private final GetSumWeightByName getSumWeightByName;
    private final GetAllByStatus getAllByStatus;
    private final GetAllByStatusAndName getAllByStatusAndName;

    public ResponseEntity<ProductDTO> addProduct(
            ProductDTO productDTO,
            Long departmentId,
            Long productNameId,
            Long productStatusId,
            Long packagingId
    ) {
        return addProduct.addProduct
                (productDTO,departmentId,productNameId,productStatusId,packagingId);
    }

    public ResponseEntity<ProductDTO> getProduct(Long productId) {
        return getProduct.getProduct(productId);
    }

    public ResponseEntity<ProductDTO> deleteProduct(Long productId) {
        return deleteProduct.deleteProduct(productId);
    }

    public ResponseEntity<ProductDTO> transport(Long productId, Long departmentId, Long productStatusId) {
        return transportProduct.transportProduct(productId, departmentId, productStatusId);
    }
    public ResponseEntity<List<ProductDTO>> getProducts() {
        return getProducts.getProducts();
    }

    public ResponseEntity<ProductDTO> updateProduct(ProductDTO productDTO, Long productId, Long productNameId, Long productStatusId, Long packagingId) {
        return updateProduct.updateProduct(productDTO, productId, productNameId, productStatusId, packagingId);
    }

    public ResponseEntity<List<ProductDTO>> getAllByName(Long productNameId) {
        return getAllByName.getAllByName(productNameId);
    }

    public ResponseEntity<ProductSumWeight> getSumWeightByName(Long productNameId) {
        return getSumWeightByName.getSumWeightByName(productNameId);
    }

    public ResponseEntity<List<ProductDTO>> getAllByStatus(Long statusId) {
        return getAllByStatus.getAllByStatus(statusId);
    }

    public ResponseEntity<List<ProductDTO>> getAllByStatusAndName(Long statusId, Long productNameId) {
        return getAllByStatusAndName.getAllByStatusAndName(statusId, productNameId);
    }
}
