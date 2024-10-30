package org.example.springjdbc_demo.mappers.entity_mapper.impl;

import org.example.springjdbc_demo.dto.ReplyDto;
import org.example.springjdbc_demo.entities.ReplyEntity;
import org.example.springjdbc_demo.mappers.entity_mapper.IBaseEntityMapper;
import org.example.springjdbc_demo.models.ReplyModel;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;

@Component
public class ReplyMapper implements IBaseEntityMapper<ReplyDto, ReplyEntity, ReplyModel> {
    @Override
    public ReplyDto toDto(ReplyEntity replyEntity) {
        return ReplyDto.builder()
                .replyId(replyEntity.getReplyId())
                .reply(replyEntity.getReply())
                .build();
    }

    @Override
    public ReplyEntity toEntity(ReplyModel replyModel) {
        return ReplyEntity.builder()
                .replyId(replyModel.getReplyId())
                .commentId(replyModel.getCommentId())
                .userId(replyModel.getUserId())
                .reply(replyModel.getReply())
                .createdAt(Timestamp.valueOf(replyModel.getCreatedAt()))
                .build();
    }
}
