package com.danieldev.VirtualWarehouse.security.service.methods;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@RequiredArgsConstructor
public class ExpirationDate {

    public Date getExpirationDate(){
        long TOKEN_DURATION = 24L * 60 * 6000 * 1000;
        return new Date(System.currentTimeMillis() + TOKEN_DURATION);
    }
}
