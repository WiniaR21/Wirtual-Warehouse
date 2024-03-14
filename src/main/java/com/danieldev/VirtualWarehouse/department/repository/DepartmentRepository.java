package com.danieldev.VirtualWarehouse.department.repository;

import com.danieldev.VirtualWarehouse.department.department.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department,Long> {
}
