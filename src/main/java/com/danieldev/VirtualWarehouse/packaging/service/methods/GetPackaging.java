package com.danieldev.VirtualWarehouse.packaging.service.methods;

import com.danieldev.VirtualWarehouse.packaging.packaging.Packaging;
import com.danieldev.VirtualWarehouse.packaging.packaging.PackagingDTO;
import com.danieldev.VirtualWarehouse.utils.methods.FindPackagingById;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GetPackaging {
    private final FindPackagingById findPackagingById;

    public ResponseEntity<PackagingDTO> getPackaging(Long id) {
        Packaging packaging = findPackagingById.find(id);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(new PackagingDTO(packaging));
    }
}
