package org.example.userservice.model;

public record UserDto (
        String firstName,
        String lastName,
        String email,
        String role,
        String password) {
}
