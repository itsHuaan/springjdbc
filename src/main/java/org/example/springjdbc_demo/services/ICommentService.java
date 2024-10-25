package org.example.springjdbc_demo.services;

import org.example.springjdbc_demo.dto.CommentDto;
import org.example.springjdbc_demo.models.CommentModel;

public interface ICommentService extends IBaseService<CommentDto, CommentModel, Long> {
}
