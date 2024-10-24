package org.example.springjdbc_demo.services;

import org.apache.catalina.User;
import org.example.springjdbc_demo.dto.UserDto;
import org.example.springjdbc_demo.entities.UserEntity;
import org.example.springjdbc_demo.models.UserModel;

public interface IUserService extends IBaseService<UserDto, UserEntity, Long> {
}
