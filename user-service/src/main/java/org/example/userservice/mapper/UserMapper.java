package org.example.userservice.mapper;

import org.example.userservice.model.User;
import org.example.userservice.model.UserDto;
import org.example.userservice.model.UserResponseDTO;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);
    User toUser(UserDto userDto);
    void updateUser(@MappingTarget User user, UserDto userDto);

    UserResponseDTO toUserResponseDTO(User user);
}
