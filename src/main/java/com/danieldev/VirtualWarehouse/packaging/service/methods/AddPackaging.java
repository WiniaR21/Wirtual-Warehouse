package com.danieldev.VirtualWarehouse.packaging.service.methods;

import com.danieldev.VirtualWarehouse.packaging.packaging.Packaging;
import com.danieldev.VirtualWarehouse.packaging.packaging.PackagingDTO;
import com.danieldev.VirtualWarehouse.exceptionHandler.exceptions.conflict.PackagingAlredyExistException;
import com.danieldev.VirtualWarehouse.packaging.repository.PackagingRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AddPackaging {
    private final PackagingRepository packagingRepository;

    @Transactional
    public ResponseEntity<PackagingDTO> addPackaging(PackagingDTO request) {

        Packaging packaging = new Packaging(request);

        try {
            packagingRepository.save(packaging);
        }
        catch (DataIntegrityViolationException e){
            throw new PackagingAlredyExistException();
        }

        return ResponseEntity.status(HttpStatus.CREATED).body(new PackagingDTO(packaging));
    }
}
