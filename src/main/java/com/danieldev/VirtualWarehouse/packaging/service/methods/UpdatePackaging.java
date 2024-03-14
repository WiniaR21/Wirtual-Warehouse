package com.danieldev.VirtualWarehouse.packaging.service.methods;

import com.danieldev.VirtualWarehouse.utils.fields.Capacity;
import com.danieldev.VirtualWarehouse.utils.fields.Name;
import com.danieldev.VirtualWarehouse.utils.fields.Weight;
import com.danieldev.VirtualWarehouse.packaging.packaging.Packaging;
import com.danieldev.VirtualWarehouse.packaging.packaging.PackagingDTO;
import com.danieldev.VirtualWarehouse.packaging.repository.PackagingRepository;
import com.danieldev.VirtualWarehouse.utils.methods.FindPackagingById;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UpdatePackaging {
    private final PackagingRepository packagingRepository;
    private final FindPackagingById findPackagingById;
    public ResponseEntity<PackagingDTO> updatePackaging(Long id, PackagingDTO request) {
        Packaging packaging = findPackagingById.find(id);

        packaging.setName(new Name(request.getPackagingName()));
        packaging.setCapacity(new Capacity(request.getCapacity()));
        packaging.setWeight(new Weight(request.getWeight()));

        packagingRepository.save(packaging);

        return ResponseEntity.status(HttpStatus.OK).body(new PackagingDTO(packaging));
    }
}
