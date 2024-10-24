package org.example.springjdbc_demo.mappers.entity_mapper.impl;

import org.example.springjdbc_demo.dto.PostDto;
import org.example.springjdbc_demo.entities.PostEntity;
import org.example.springjdbc_demo.mappers.entity_mapper.IBaseEntityMapper;
import org.example.springjdbc_demo.models.PostModel;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;

@Component
public class PostMapper implements IBaseEntityMapper<PostDto, PostEntity, PostModel> {
    @Override
    public PostDto toDto(PostEntity postEntity) {
        return PostDto.builder()
                .title(postEntity.getTitle())
                .content(postEntity.getContent())
                .commentId(postEntity.getCommentId())
                .createdAt(postEntity.getCreatedAt().toLocalDateTime())
                .build();
    }

    @Override
    public PostEntity toEntity(PostModel postModel) {
        return PostEntity.builder()
                .postId(postModel.getPostId())
                .title(postModel.getTitle())
                .content(postModel.getContent())
                .commentId(postModel.getCommentId())
                .createdAt(Timestamp.valueOf(postModel.getCreatedAt()))
                .build();
    }
}
