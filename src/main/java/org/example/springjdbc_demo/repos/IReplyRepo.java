package org.example.springjdbc_demo.repos;

import org.example.springjdbc_demo.dto.ReplyDto;
import org.example.springjdbc_demo.entities.ReplyEntity;

import java.util.List;

public interface IReplyRepo extends IBaseRepo<ReplyEntity, Long>{
    List<ReplyDto> getByCommentId(Long id);
}
