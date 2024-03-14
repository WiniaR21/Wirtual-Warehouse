package com.danieldev.VirtualWarehouse.utils.methods;

import com.danieldev.VirtualWarehouse.packaging.packaging.Packaging;
import com.danieldev.VirtualWarehouse.exceptionHandler.exceptions.notFound.PackagingNotFoundException;
import com.danieldev.VirtualWarehouse.packaging.repository.PackagingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FindPackagingById {
    private final PackagingRepository packagingRepository;

    public Packaging find(Long id){
        return packagingRepository.findById(id).orElseThrow(
                () -> new PackagingNotFoundException(id)
        );
    }
}
