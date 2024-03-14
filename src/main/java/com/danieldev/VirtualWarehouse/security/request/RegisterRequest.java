package com.danieldev.VirtualWarehouse.security.request;

import com.danieldev.VirtualWarehouse.security.user.Role;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class RegisterRequest {
    private String firstName;
    private String lastName;
    private String username;
    private String password;
    private Role role;
}
