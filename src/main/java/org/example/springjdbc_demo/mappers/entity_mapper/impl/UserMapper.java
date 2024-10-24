package org.example.springjdbc_demo.mappers.entity_mapper.impl;

import org.example.springjdbc_demo.dto.UserDto;
import org.example.springjdbc_demo.entities.UserEntity;
import org.example.springjdbc_demo.mappers.entity_mapper.IBaseEntityMapper;
import org.example.springjdbc_demo.models.UserModel;
import org.springframework.stereotype.Component;

@Component
public class UserMapper implements IBaseEntityMapper<UserDto, UserEntity, UserModel> {
    @Override
    public UserDto toDto(UserEntity userEntity) {
        return UserDto.builder()
                .username(userEntity.getUsername())
                .name(userEntity.getName())
                .build();
    }

    @Override
    public UserEntity toEntity(UserModel userModel) {
        return UserEntity.builder()
                .userId(userModel.getUserId())
                .username(userModel.getUsername())
                .name(userModel.getName())
                .status(userModel.getStatus())
                .build();
    }
}
