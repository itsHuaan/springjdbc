package org.example.springjdbc_demo.services.impl;

import org.example.springjdbc_demo.dto.UserDto;
import org.example.springjdbc_demo.entities.UserEntity;
import org.example.springjdbc_demo.mappers.entity_mapper.impl.UserMapper;
import org.example.springjdbc_demo.models.UserModel;
import org.example.springjdbc_demo.repos.impl.UserRepo;
import org.example.springjdbc_demo.services.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements IUserService {
    private final UserRepo userRepo;
    private final UserMapper userMapper;

    @Autowired
    public UserService(UserRepo userRepo, UserMapper userMapper) {
        this.userRepo = userRepo;
        this.userMapper = userMapper;
    }

    @Override
    public List<UserDto> getAll() {
        return userRepo.getAll().stream().map(userMapper::toDto).toList();
    }

    @Override
    public UserDto getById(Long id) {
        UserEntity userEntity = userRepo.getById(id);
        return userEntity != null ? userMapper.toDto(userEntity) : null;
    }

    @Override
    public int save(UserModel userModel) {
        return userRepo.save(userMapper.toEntity(userModel));
    }

    @Override
    public int delete(Long id) {
        return userRepo.delete(id);
    }
}
