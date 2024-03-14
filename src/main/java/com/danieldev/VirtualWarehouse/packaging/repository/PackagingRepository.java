package com.danieldev.VirtualWarehouse.packaging.repository;

import com.danieldev.VirtualWarehouse.utils.fields.Name;
import com.danieldev.VirtualWarehouse.packaging.packaging.Packaging;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PackagingRepository extends JpaRepository<Packaging, Long> {
    Optional<Packaging> findByName(Name name);
}
