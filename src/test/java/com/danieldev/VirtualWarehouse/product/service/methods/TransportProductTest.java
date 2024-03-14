package com.danieldev.VirtualWarehouse.product.service.methods;

import static com.danieldev.VirtualWarehouse.utilsForTesting.UtilsForTesting.getValidDepartment;
import static com.danieldev.VirtualWarehouse.utilsForTesting.UtilsForTesting.getValidProduct;
import static org.junit.jupiter.api.Assertions.*;



import com.danieldev.VirtualWarehouse.department.department.DepartmentsProductManager;
import com.danieldev.VirtualWarehouse.exceptionHandler.exceptions.conflict.TransportConflictException;
import com.danieldev.VirtualWarehouse.product.product.Product;
import com.danieldev.VirtualWarehouse.product.product.ProductDTO;
import com.danieldev.VirtualWarehouse.product.repository.ProductRepository;
import com.danieldev.VirtualWarehouse.productName.productName.ProductName;
import com.danieldev.VirtualWarehouse.productStatus.productStatus.ProductStatus;
import com.danieldev.VirtualWarehouse.utils.fields.Name;
import com.danieldev.VirtualWarehouse.utils.methods.FindDepartmentById;
import com.danieldev.VirtualWarehouse.utils.methods.FindProductById;
import com.danieldev.VirtualWarehouse.utils.methods.FindProductStatusById;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.mockito.Mockito.*;
class TransportProductTest {

    @Mock
    private FindProductById findProductById;

    @Mock
    private FindDepartmentById findDepartmentById;

    @Mock
    private ProductRepository productRepository;

    @Mock
    private FindProductStatusById findProductStatusById;

    @Mock
    private DepartmentsProductManager departmentsProductManager;

    @InjectMocks
    private TransportProduct transportProduct;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void transportProductShouldThrowTransportConflictException() {
        // Arrange
        Long productId = 1L;
        Long departmentId = 1L;


        Product product = getValidProduct();

        when(findProductById.find(productId)).thenReturn(product);
        when(findDepartmentById.find(departmentId)).thenReturn(product.getDepartment());

        // Assert
        assertThrows(TransportConflictException.class,
                () -> transportProduct.transportProduct(productId,departmentId, null));

    }

    @Test
    void transportProductShouldReturnFineResponseEntityProductHaveNewStatus(){
        // Arrange
        Long productId = 1L;
        Long departmentId = 1L;
        Long productStatusId = 1L;

        Product product = getValidProduct();

        ProductStatus newProductStatus = new ProductStatus();
        newProductStatus.setName(new Name("new productStatus"));

        ProductDTO expectedDto = new ProductDTO(product);
        expectedDto.setProductStatus("new productStatus");


        when(findProductById.find(productId)).thenReturn(product);
        when(findDepartmentById.find(departmentId)).thenReturn(getValidDepartment("new department"));
        when(findProductStatusById.find(productStatusId)).thenReturn(newProductStatus);




        // Assert
        assertEquals(ResponseEntity.status(HttpStatus.OK).body(expectedDto),
                transportProduct.transportProduct(productId,departmentId,productStatusId) );
    }


}