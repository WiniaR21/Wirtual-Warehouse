package com.danieldev.VirtualWarehouse.security.service.methods;

import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;

@Component
@RequiredArgsConstructor
public class KeyWriter {
    public SecretKey getSignKey(){
        String SECRET_KEY = "d977816996de2deaf91666d3d943690b1265d33f054f5bf6ce149ac7e69c5f26";

        byte[] keyBytes = Decoders
                .BASE64URL
                .decode(SECRET_KEY);

        return Keys.hmacShaKeyFor(keyBytes);
    }
}
