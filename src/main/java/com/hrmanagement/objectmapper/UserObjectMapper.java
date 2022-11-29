package com.hrmanagement.objectmapper;

import com.hrmanagement.domain.training.TrainingResponseDto;
import com.hrmanagement.domain.user.User;
import com.hrmanagement.domain.user.UserResponseDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface UserObjectMapper {
    UserObjectMapper INSTANCE = Mappers.getMapper(UserObjectMapper.class);
    UserResponseDto toResponse(User user);
}
