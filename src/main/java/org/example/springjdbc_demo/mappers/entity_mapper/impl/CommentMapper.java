package org.example.springjdbc_demo.mappers.entity_mapper.impl;

import org.example.springjdbc_demo.dto.CommentDto;
import org.example.springjdbc_demo.entities.CommentEntity;
import org.example.springjdbc_demo.mappers.entity_mapper.IBaseEntityMapper;
import org.example.springjdbc_demo.models.CommentModel;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;

@Component
public class CommentMapper implements IBaseEntityMapper<CommentDto, CommentEntity, CommentModel> {
    @Override
    public CommentDto toDto(CommentEntity commentEntity) {
        return CommentDto.builder()
                .commentId(commentEntity.getCommentId())
                .userId(commentEntity.getUserId())
                .postId(commentEntity.getPostId())
                .comment(commentEntity.getComment())
                .createdAt(commentEntity.getCreatedAt().toLocalDateTime())
                .build();
    }

    @Override
    public CommentEntity toEntity(CommentModel commentModel) {
        return CommentEntity.builder()
                .commentId(commentModel.getCommentId())
                .userId(commentModel.getUserId())
                .postId(commentModel.getPostId())
                .comment(commentModel.getComment())
                .createdAt(Timestamp.valueOf(commentModel.getCreatedAt()))
                .build();
    }
}
