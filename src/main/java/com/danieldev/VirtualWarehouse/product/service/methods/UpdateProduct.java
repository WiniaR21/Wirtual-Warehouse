package com.danieldev.VirtualWarehouse.product.service.methods;

import com.danieldev.VirtualWarehouse.packaging.packaging.Packaging;
import com.danieldev.VirtualWarehouse.product.product.Product;
import com.danieldev.VirtualWarehouse.product.product.ProductDTO;
import com.danieldev.VirtualWarehouse.product.product.ProductWeight;
import com.danieldev.VirtualWarehouse.product.repository.ProductRepository;
import com.danieldev.VirtualWarehouse.productName.productName.ProductName;
import com.danieldev.VirtualWarehouse.productStatus.productStatus.ProductStatus;
import com.danieldev.VirtualWarehouse.utils.fields.Weight;
import com.danieldev.VirtualWarehouse.utils.methods.FindPackagingById;
import com.danieldev.VirtualWarehouse.utils.methods.FindProductById;
import com.danieldev.VirtualWarehouse.utils.methods.FindProductNameById;
import com.danieldev.VirtualWarehouse.utils.methods.FindProductStatusById;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UpdateProduct {
    private final FindProductById findProductById;
    private final FindProductNameById findProductNameById;
    private final FindProductStatusById findProductStatusById;
    private final FindPackagingById findPackagingById;
    private final ProductRepository productRepository;
    public ResponseEntity<ProductDTO> updateProduct
            (
                    ProductDTO productDTO,
                    Long productId,
                    Long productNameId,
                    Long productStatusId,
                    Long packagingId
            )
    {
        Product product = findProductById.find(productId);
        ProductName productName = findProductNameById.find(productNameId);
        ProductStatus productStatus = findProductStatusById.find(productStatusId);
        Packaging packaging = findPackagingById.find(packagingId);

        product.setProductName(productName);
        product.setProductStatus(productStatus);
        product.setPackaging(packaging);

        product.setProductWeight(new ProductWeight(new Weight(productDTO.getGrossWeight()),packaging));

        productRepository.save(product);

        return ResponseEntity.status(HttpStatus.OK).body(new ProductDTO(product));
    }
}
