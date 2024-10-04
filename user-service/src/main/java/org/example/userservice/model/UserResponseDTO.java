package org.example.userservice.model;

public record UserResponseDTO (
        long id,
        String firstName,
        String lastName,
        String email,
        String role) {
}
