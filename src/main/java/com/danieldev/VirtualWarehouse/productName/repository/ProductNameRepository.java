package com.danieldev.VirtualWarehouse.productName.repository;

import com.danieldev.VirtualWarehouse.utils.fields.Name;
import com.danieldev.VirtualWarehouse.productName.productName.ProductName;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProductNameRepository extends JpaRepository<ProductName, Long> {
    Optional<ProductName> findByName(Name name);
}
