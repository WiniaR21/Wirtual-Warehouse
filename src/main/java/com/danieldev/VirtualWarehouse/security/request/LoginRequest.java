package com.danieldev.VirtualWarehouse.security.request;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class LoginRequest {
    String username;
    String password;
}
