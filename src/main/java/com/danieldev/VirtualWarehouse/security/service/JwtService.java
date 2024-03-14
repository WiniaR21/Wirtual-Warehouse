package com.danieldev.VirtualWarehouse.security.service;


import com.danieldev.VirtualWarehouse.security.service.methods.ExtractClaim;
import com.danieldev.VirtualWarehouse.security.service.methods.TokenGenerator;
import com.danieldev.VirtualWarehouse.security.service.methods.ValidToken;
import com.danieldev.VirtualWarehouse.security.user.User;
import io.jsonwebtoken.Claims;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class JwtService {
    private final TokenGenerator tokenGenerator;
    private final ExtractClaim extractClaim;
    private final ValidToken validToken;

    public boolean isValid(String token, UserDetails user){
        return validToken.isValid(token,user);
    }

    public String extractUsername(String token){
        return extractClaim.extract(token, Claims::getSubject);
    }

    public String generateToken(User user){
        return tokenGenerator.generateToken(user);
    }

}
