package org.example.userservice.service;

import jakarta.transaction.Transactional;
import org.example.userservice.mapper.UserMapper;
import org.example.userservice.model.User;
import org.example.userservice.model.UserDto;
import org.example.userservice.model.UserResponseDTO;
import org.example.userservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public List<UserResponseDTO> getAllUsersAsUserResponseDTO(){
        return getAllUsers().stream().map(UserMapper.INSTANCE::toUserResponseDTO).toList();
    }

    public User getUserById(Long id) throws IllegalArgumentException {
        Optional<User> user = userRepository.findById(id);
        return user.orElseThrow(IllegalArgumentException::new);
    }

    public UserResponseDTO getUserResponseDTOById(Long id) throws IllegalArgumentException {
        return UserMapper.INSTANCE.toUserResponseDTO(getUserById(id));
    }

    @Transactional
    public User createUser(UserDto userdto) {
        if( Objects.isNull(userdto)) throw new IllegalArgumentException();
        User user = UserMapper.INSTANCE.toUser(userdto);

        if(userRepository.existsByEmail(user.getEmail())) {
            throw new IllegalArgumentException("Email already in use");
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    public User updateUser(Long id, UserDto userdto) {
        User user = userRepository.findById(id).orElseThrow(IllegalArgumentException::new);
        UserMapper.INSTANCE.updateUser(user, userdto);
        if(userdto.password() != null) user.setPassword(passwordEncoder.encode(userdto.password()));
        return userRepository.save(user);
    }

    public void deleteUser(long id) {
        userRepository.deleteById(id);
    }
}
