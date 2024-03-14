package com.danieldev.VirtualWarehouse.product.repository;

import com.danieldev.VirtualWarehouse.packaging.packaging.Packaging;
import com.danieldev.VirtualWarehouse.product.product.Product;
import com.danieldev.VirtualWarehouse.product.product.ProductDTO;
import com.danieldev.VirtualWarehouse.productName.productName.ProductName;
import com.danieldev.VirtualWarehouse.productStatus.productStatus.ProductStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long> {
    boolean existsByPackaging(Packaging packaging);
    boolean existsByProductStatus(ProductStatus productStatus);
    boolean existsByProductName(ProductName productName);
    List<Product> findAllByProductName(ProductName productName);
    @Query("SELECT SUM(p.productWeight.grossWeight.value) FROM Product p WHERE p.productName = :productName")
    BigDecimal getSumOfGrossWeightByProductName(ProductName productName);
    @Query("SELECT SUM(p.productWeight.netWeight.value) FROM Product p WHERE p.productName = :productName")
    BigDecimal getSumOfNetWeightByProductName(ProductName productName);
    List<Product> findAllByProductStatus(ProductStatus productStatus);

    List<Product> findAllByProductNameAndProductStatus(ProductName productName, ProductStatus productStatus);

}
