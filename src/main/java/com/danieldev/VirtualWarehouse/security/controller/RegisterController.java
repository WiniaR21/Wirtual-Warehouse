package com.danieldev.VirtualWarehouse.security.controller;

import com.danieldev.VirtualWarehouse.security.request.RegisterRequest;
import com.danieldev.VirtualWarehouse.security.service.RegisterService;
import com.danieldev.VirtualWarehouse.security.user.AuthenticationResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@CrossOrigin
public class RegisterController {
    private final RegisterService registerService;

    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> register(
            @RequestBody RegisterRequest request
    ) {
        return registerService.register(request);
    }
}