package com.danieldev.VirtualWarehouse.packaging.service.methods;

import com.danieldev.VirtualWarehouse.packaging.packaging.PackagingDTO;
import com.danieldev.VirtualWarehouse.packaging.repository.PackagingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class GetPackagingS {
    private final PackagingRepository packagingRepository;

    public ResponseEntity<List<PackagingDTO>> getPackagingS() {
        List<PackagingDTO> packagingDTOList = new ArrayList<>();

        packagingRepository
                .findAll()
                .forEach(packaging -> packagingDTOList.add(new PackagingDTO(packaging)));

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(packagingDTOList);

    }
}
