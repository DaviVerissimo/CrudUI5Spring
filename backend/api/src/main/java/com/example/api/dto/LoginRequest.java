package com.example.api.dto;

public record LoginRequest(
        String email,
        String password
) {
}
