package com.danieldev.VirtualWarehouse.security.service.methods;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@RequiredArgsConstructor
public class IsTokenExpired {
    private final ExtractExpirationDate extractExpirationDate;
    public boolean check(String token){
        return extractExpirationDate.extract(token)
                .before(new Date());
    }
}
