package com.danieldev.VirtualWarehouse.security.service;

import com.danieldev.VirtualWarehouse.security.request.LoginRequest;
import com.danieldev.VirtualWarehouse.security.user.User;
import com.danieldev.VirtualWarehouse.security.user.UserDTO;
import com.danieldev.VirtualWarehouse.security.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LoginService {
    private final AuthenticationManager authenticationManager;
    private final UserRepository userRepository;
    private final JwtService jwtService;

    public ResponseEntity<UserDTO> login(LoginRequest request){
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getUsername(),
                        request.getPassword()
                )
        );
        User user = userRepository.findAllByUsername(request.getUsername()).orElseThrow();
        String token = jwtService.generateToken(user);

        return ResponseEntity.status(HttpStatus.OK).body(new UserDTO(user,token));
    }
}
