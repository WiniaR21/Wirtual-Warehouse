package com.danieldev.VirtualWarehouse.security.user;


import com.danieldev.VirtualWarehouse.utils.abstracts.ObjectDTO;
import com.danieldev.VirtualWarehouse.utils.fields.Method;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.sql.Struct;
import java.util.List;

@EqualsAndHashCode(callSuper = false)
@Data
@NoArgsConstructor
public class UserDTO extends ObjectDTO {
    private String firstName;
    private String lastName;
    private String username;
    private Role role;

    private String token;

    public UserDTO(User user, String token) {
        this.id = user.getId();
        this.firstName = user.getFirstName();
        this.lastName = user.getLastName();
        this.username = user.getUsername();
        this.role = user.getRole();

        this.token = token;
        configureActions();
    }
    private void configureActions(){
        String addDepartmentUri = "/departments/addDepartment";
        String addToProducesId = "/departments/{departmentId}/addToProduces";
        String departmentByIdUri = "/departments/{departmentId}";
        String removeFromProducesUri = "/departments/{departmentId}/removeFromProduces";

        String addPackagingUri = "/packaging-s/add";
        String packagingByIdUri = "/packaging-s/{packagingId}";

        String addProductNameUri = "/productNames/add";
        String productNameByIdUri = "/productNames/{productNameId}";

        String addProductStatusUri = "/productStatuses/add";
        String productStatusByIdUri = "/productStatuses/{productStatusId}";

        String addProductUri = "/products/addProduct";
        String productByIdUri = "/products/{productId}";


        addAction("Get department by id", departmentByIdUri, Method.GET);

        addAction("Get packaging by id", packagingByIdUri, Method.GET);
        addAction("Get all packaging's", "/packaging-s", Method.GET);

        addAction("Get product name by id", productNameByIdUri, Method.GET);
        addAction("Get all product names", "/productNames", Method.GET);

        addAction("Get product status by id", productStatusByIdUri, Method.GET);
        addAction("Get all product statuses", "/productStatuses", Method.GET);

        addAction("Add product", addProductUri, Method.POST, List.of("departmentId", "productNameId","productStatusId","packagingId"));
        addAction("Get product by id", productByIdUri, Method.GET);
        addAction("Update product", productByIdUri, Method.PUT, List.of("productId", "productNameId","packagingId","productStatusId"));


        if (role == Role.ADMIN){
            //  Department
            addAction("Add new department", addDepartmentUri, Method.POST);
            addAction("Add to produces in department", addToProducesId, Method.POST);
            addAction("Delete department", departmentByIdUri, Method.DELETE);
            addAction("Remove from produces", removeFromProducesUri, Method.PUT);
            addAction("Get all departments", "/departments", Method.GET);
            //  Packaging
            addAction("Add new packaging", addPackagingUri, Method.POST);
            addAction("Delete packaging", packagingByIdUri, Method.DELETE);
            addAction("Update packaging", packagingByIdUri, Method.PUT);
            // ProductName
            addAction("Add product name", addProductNameUri, Method.POST, List.of("departmentId"));
            addAction("Remove product name", productNameByIdUri, Method.DELETE);
            addAction("Update product name", productNameByIdUri, Method.PUT);
            // ProductStatus
            addAction("Add product status", addProductStatusUri, Method.POST);
            addAction("Remove product status", productStatusByIdUri, Method.DELETE);
            addAction("Update product status", productStatusByIdUri, Method.PUT);
            //  Product
            addAction("Delete product", productByIdUri, Method.DELETE);
            addAction("Get all by product name", "/products/allByName", Method.GET, List.of("productNameId"));
            addAction("Get all by status", "/products/allByStatus", Method.GET, List.of("statusId"));
            addAction("Get all by status and name", "/products/allByStatusAndName", Method.GET, List.of("statusId", "productNameId"));
            addAction("Get sum weight by name", "/products/sumWeightByName", Method.GET, List.of("productNameId"));
            addAction("Transport product", "/products/{productId}/transport", Method.PUT, List.of("departmentId", "optional: productStatusId"));
        }
        else if (role == Role.MANAGER) {
            //  Department
            addAction("Add new department", addDepartmentUri, Method.POST);
            addAction("Remove from produces", removeFromProducesUri, Method.PUT);
            addAction("Get all departments", "/departments", Method.GET);
            //  Packaging
            addAction("Add new packaging", addPackagingUri, Method.POST);
            addAction("Delete packaging", packagingByIdUri, Method.DELETE);
            addAction("Update packaging", packagingByIdUri, Method.PUT);
            // ProductName
            addAction("Add product name", addProductNameUri, Method.POST, List.of("departmentId"));
            addAction("Remove product name", productNameByIdUri, Method.DELETE);
            addAction("Update product name", productNameByIdUri, Method.PUT);
            // ProductStatus
            addAction("Add product status", addProductStatusUri, Method.POST);
            addAction("Remove product status", productStatusByIdUri, Method.DELETE);
            addAction("Update product status", productStatusByIdUri, Method.PUT);
            //  Product
            addAction("Delete product", productByIdUri, Method.DELETE);
            addAction("Get all by product name", "/products/allByName", Method.GET);
            addAction("Get all by status", "/products/allByStatus", Method.GET, List.of("statusId"));
            addAction("Get all by status and name", "/products/allByStatusAndName", Method.GET, List.of("statusId", "productNameId"));
            addAction("Get sum weight by name", "/products/sumWeightByName", Method.GET, List.of("productNameId"));
            addAction("Transport product", "/products/{productId}/transport", Method.PUT, List.of("departmentId", "optional: productStatusId"));
        }

    }
}
