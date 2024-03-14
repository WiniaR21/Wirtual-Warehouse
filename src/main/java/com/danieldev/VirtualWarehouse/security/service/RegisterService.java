package com.danieldev.VirtualWarehouse.security.service;

import com.danieldev.VirtualWarehouse.exceptionHandler.exceptions.conflict.RegisterUserNameException;
import com.danieldev.VirtualWarehouse.security.request.RegisterRequest;
import com.danieldev.VirtualWarehouse.security.user.AuthenticationResponse;
import com.danieldev.VirtualWarehouse.security.user.User;
import com.danieldev.VirtualWarehouse.security.user.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RegisterService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    @Transactional
    public ResponseEntity<AuthenticationResponse> register(RegisterRequest request){
        //  TODO unique username

        User user = new User();
        user.setFirstName(request.getFirstName());
        user.setLastName(request.getLastName());
        user.setUsername(request.getUsername());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setRole(request.getRole());

        try {
            userRepository.save(user);
        }
        catch (DataIntegrityViolationException e){
           throw new RegisterUserNameException(user.getUsername());
        }

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new AuthenticationResponse(user.getId(), user.getRole()));

    }
}
