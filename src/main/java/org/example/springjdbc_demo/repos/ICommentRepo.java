package org.example.springjdbc_demo.repos;

import org.example.springjdbc_demo.entities.CommentEntity;

import java.util.List;

public interface ICommentRepo extends IBaseRepo<CommentEntity, Long> {
    List<CommentEntity> getByPostId(Long id);
    List<CommentEntity> getByUserId(Long id);
    CommentEntity getSpecificComment(CommentEntity comment);
}
