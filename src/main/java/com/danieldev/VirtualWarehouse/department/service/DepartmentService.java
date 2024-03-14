package com.danieldev.VirtualWarehouse.department.service;

import com.danieldev.VirtualWarehouse.department.department.DepartmentDTO;
import com.danieldev.VirtualWarehouse.department.service.methods.*;
import com.danieldev.VirtualWarehouse.packaging.packaging.PackagingDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DepartmentService {
    private final AddDepartment addDepartment;
    private final AddToProduces addToProduces;
    private final RemoveFromProduces removeFromProduces;
    private final GetDepartment getDepartment;
    private final GetDepartments getDepartments;
    private final RemoveDepartment removeDepartment;
    public ResponseEntity<DepartmentDTO> addDepartment(DepartmentDTO request) {
        return addDepartment.addDepartment(request);
    }
    public ResponseEntity<DepartmentDTO> addToProduces(Long departmentId, Long productNameId) {
        return addToProduces.addToProduces(departmentId, productNameId);
    }
    public ResponseEntity<DepartmentDTO> removeFromProduces(Long departmentId, Long productNameId) {
        return removeFromProduces.removeFromProduces(departmentId, productNameId);
    }
    public ResponseEntity<DepartmentDTO> getDepartment(Long departmentId) {
        return getDepartment.getDepartment(departmentId);
    }
    public ResponseEntity<List<DepartmentDTO>> getPackagingS() {
        return getDepartments.getDepartments();
    }

    public ResponseEntity<PackagingDTO> removeDepartment(Long id) {
        return removeDepartment.removeDepartment(id);
    }
}
