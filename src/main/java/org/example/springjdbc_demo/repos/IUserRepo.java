package org.example.springjdbc_demo.repos;

import org.example.springjdbc_demo.dto.UserWithCommentDto;
import org.example.springjdbc_demo.entities.UserEntity;

import java.util.List;

public interface IUserRepo extends IBaseRepo<UserEntity, Long> {
    List<UserWithCommentDto> getByPostId(Long postId);
}
