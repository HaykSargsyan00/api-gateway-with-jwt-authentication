package org.example.userservice.service;

import org.example.userservice.model.User;
import org.example.userservice.model.UserDto;
import org.example.userservice.model.UserResponseDTO;

import java.util.List;

public interface UserService {
    User getUserById(Long id) throws IllegalArgumentException;
    UserResponseDTO getUserResponseDTOById(Long id) throws IllegalArgumentException;
    List<User> getAllUsers();
    List<UserResponseDTO> getAllUsersAsUserResponseDTO();
    User createUser(UserDto user);
    User updateUser(Long id, UserDto userdto);
    void deleteUser(long id);
}
