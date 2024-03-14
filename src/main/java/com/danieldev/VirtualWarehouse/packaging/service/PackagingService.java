package com.danieldev.VirtualWarehouse.packaging.service;

import com.danieldev.VirtualWarehouse.packaging.packaging.PackagingDTO;
import com.danieldev.VirtualWarehouse.packaging.service.methods.GetPackaging;
import com.danieldev.VirtualWarehouse.packaging.service.methods.GetPackagingS;
import com.danieldev.VirtualWarehouse.packaging.service.methods.AddPackaging;
import com.danieldev.VirtualWarehouse.packaging.service.methods.RemovePackaging;
import com.danieldev.VirtualWarehouse.packaging.service.methods.UpdatePackaging;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PackagingService {
    private final AddPackaging addPackaging;
    private final RemovePackaging removePackaging;
    private final UpdatePackaging updatePackaging;
    private final GetPackaging getPackaging;
    private final GetPackagingS getPackagingS;

    public ResponseEntity<PackagingDTO> getPackaging(Long id) {
        return getPackaging.getPackaging(id);
    }

    public ResponseEntity<List<PackagingDTO>> getPackagingS() {
        return getPackagingS.getPackagingS();
    }

    public ResponseEntity<PackagingDTO> addPackaging(PackagingDTO request) {
        return addPackaging.addPackaging(request);
    }

    public ResponseEntity<PackagingDTO> removePackaging(Long id) {
        return removePackaging.removePackaging(id);
    }

    public ResponseEntity<PackagingDTO> updatePackaging(Long id, PackagingDTO request) {
        return updatePackaging.updatePackaging(id, request);
    }
}
