package org.example.springjdbc_demo.services;

import org.example.springjdbc_demo.dto.CommentDto;
import org.example.springjdbc_demo.entities.CommentEntity;
import org.example.springjdbc_demo.models.CommentModel;

import java.util.List;

public interface ICommentService extends IBaseService<CommentDto, CommentModel, Long> {
    List<CommentDto> getByPostId(Long id);
    List<CommentDto> getByUserId(Long id);
    List<CommentDto> getSpecificComment(Long postId, Long userId);
}
