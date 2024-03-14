package com.danieldev.VirtualWarehouse.security.controller;

import com.danieldev.VirtualWarehouse.security.request.LoginRequest;
import com.danieldev.VirtualWarehouse.security.service.LoginService;
import com.danieldev.VirtualWarehouse.security.user.AuthenticationResponse;
import com.danieldev.VirtualWarehouse.security.user.UserDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@CrossOrigin
public class LoginController {
    private final LoginService loginService;
    @PostMapping("/login")
    public ResponseEntity<UserDTO> login(
            @RequestBody LoginRequest request
    ){
       return loginService.login(request);
    }
}
