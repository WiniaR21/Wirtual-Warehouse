package com.danieldev.VirtualWarehouse.security.config;


import com.danieldev.VirtualWarehouse.security.request.RegisterRequest;
import com.danieldev.VirtualWarehouse.security.service.RegisterService;
import com.danieldev.VirtualWarehouse.security.user.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class AdminConfig implements CommandLineRunner {
    private final RegisterService registerService;
    @Override
    public void run(String... args) {
        RegisterRequest request = new RegisterRequest();
        request.setFirstName("Jan");
        request.setLastName("Kowalski");
        request.setRole(Role.ADMIN);
        request.setUsername("admin");
        request.setPassword("admin");

        registerService.register(request);
    }
}
