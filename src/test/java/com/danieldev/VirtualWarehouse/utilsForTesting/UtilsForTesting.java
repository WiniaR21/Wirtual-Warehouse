package com.danieldev.VirtualWarehouse.utilsForTesting;

import com.danieldev.VirtualWarehouse.department.department.Department;
import com.danieldev.VirtualWarehouse.department.department.DepartmentDTO;
import com.danieldev.VirtualWarehouse.packaging.packaging.Packaging;
import com.danieldev.VirtualWarehouse.packaging.packaging.PackagingDTO;
import com.danieldev.VirtualWarehouse.product.product.Product;
import com.danieldev.VirtualWarehouse.product.product.ProductDTO;
import com.danieldev.VirtualWarehouse.productName.productName.ProductName;
import com.danieldev.VirtualWarehouse.productName.productName.ProductNameDTO;
import com.danieldev.VirtualWarehouse.productStatus.productStatus.ProductStatus;
import com.danieldev.VirtualWarehouse.productStatus.productStatus.ProductStatusDTO;

import java.math.BigDecimal;

public final class UtilsForTesting {
    public static Department getValidDepartment(){
        DepartmentDTO departmentDTO= new DepartmentDTO();
        departmentDTO.setDepartmentName("department");
        departmentDTO.setTotalCapacity(new BigDecimal(20));

        return new Department(departmentDTO);
    }
    public static Department getValidDepartment(String name){
        DepartmentDTO departmentDTO= new DepartmentDTO();
        departmentDTO.setDepartmentName(name);
        departmentDTO.setTotalCapacity(new BigDecimal(20));

        return new Department(departmentDTO);
    }
    public static ProductName getValidProductName(){
        ProductNameDTO productNameDTO = new ProductNameDTO();
        productNameDTO.setProductName("product");

        return new ProductName(productNameDTO);
    }
    public static ProductStatus getValidProductStatus(){
        ProductStatusDTO productStatusDTO = new ProductStatusDTO();
        productStatusDTO.setStatusName("status");

        return new ProductStatus(productStatusDTO);
    }
    public static Packaging getValidPackaging(){
        PackagingDTO packagingDTO = new PackagingDTO();
        packagingDTO.setPackagingName("packaging");
        packagingDTO.setCapacity(new BigDecimal(1));
        packagingDTO.setWeight(new BigDecimal(1));

        return new Packaging(packagingDTO);
    }
    public static Product getValidProduct() {
        ProductDTO productDTO = new ProductDTO();
        productDTO.setProductName("product");
        productDTO.setGrossWeight(new BigDecimal(1000));

        return new Product(
                productDTO,
                getValidProductName(),
                getValidDepartment(),
                getValidProductStatus(),
                getValidPackaging()
        );
    }
}
