package com.danieldev.VirtualWarehouse.utils.methods;

import com.danieldev.VirtualWarehouse.department.department.Department;
import com.danieldev.VirtualWarehouse.department.repository.DepartmentRepository;
import com.danieldev.VirtualWarehouse.exceptionHandler.exceptions.notFound.DepartmentNotFoundException;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.junit.jupiter.api.extension.ExtendWith;

import java.util.Optional;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class FindDepartmentByIdTest {

    @Mock
    private DepartmentRepository departmentRepository;

    @InjectMocks
    private FindDepartmentById findDepartmentById;

    @Test
    public void testFindDepartmentById() {
        Long id = 1L;
        Department department = new Department();
        when(departmentRepository.findById(id)).thenReturn(Optional.of(department));

        Department result = findDepartmentById.find(id);

        assertEquals(department, result);
        verify(departmentRepository, times(1)).findById(id);
    }

    @Test
    public void testFindDepartmentByIdNotFound() {
        Long id = 1L;
        when(departmentRepository.findById(id)).thenReturn(Optional.empty());

        assertThrows(DepartmentNotFoundException.class, () -> findDepartmentById.find(id));
        verify(departmentRepository, times(1)).findById(id);
    }
}
