package com.danieldev.VirtualWarehouse.security.user;



public record AuthenticationResponse(Long userId, Role role) {}
