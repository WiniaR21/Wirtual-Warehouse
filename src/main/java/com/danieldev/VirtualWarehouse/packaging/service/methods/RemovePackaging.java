package com.danieldev.VirtualWarehouse.packaging.service.methods;

import com.danieldev.VirtualWarehouse.exceptionHandler.exceptions.conflict.RemovePackagingConflictException;
import com.danieldev.VirtualWarehouse.packaging.packaging.Packaging;
import com.danieldev.VirtualWarehouse.packaging.packaging.PackagingDTO;
import com.danieldev.VirtualWarehouse.packaging.repository.PackagingRepository;
import com.danieldev.VirtualWarehouse.product.repository.ProductRepository;
import com.danieldev.VirtualWarehouse.utils.methods.FindPackagingById;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RemovePackaging {
    private final ProductRepository productRepository;
    private final PackagingRepository packagingRepository;
    private final FindPackagingById findPackagingById;
    @Transactional
    public ResponseEntity<PackagingDTO> removePackaging(Long id)
    {
        Packaging packaging = findPackagingById.find(id);

        if (productRepository.existsByPackaging(packaging)){
            throw new RemovePackagingConflictException(id);
        }
        else {
            packagingRepository.delete(packaging);
        }
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
    }
}
