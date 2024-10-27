package org.example.springjdbc_demo.services.impl;

import org.example.springjdbc_demo.dto.CommentDto;
import org.example.springjdbc_demo.mappers.entity_mapper.impl.CommentMapper;
import org.example.springjdbc_demo.models.CommentModel;
import org.example.springjdbc_demo.repos.impl.CommentRepo;
import org.example.springjdbc_demo.services.ICommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService implements ICommentService {
    private final CommentRepo commentRepo;
    private final CommentMapper commentMapper;

    @Autowired
    public CommentService(CommentRepo commentRepo, CommentMapper commentMapper) {
        this.commentRepo = commentRepo;
        this.commentMapper = commentMapper;
    }

    @Override
    public List<CommentDto> getAll() {
        return commentRepo.getAll().stream().map(commentMapper::toDto).toList();
    }

    @Override
    public CommentDto getById(Long id) {
        return null;
    }

    @Override
    public int save(CommentModel commentModel) {
        return commentRepo.save(commentMapper.toEntity(commentModel));
    }

    @Override
    public int delete(Long id) {
        return commentRepo.delete(id);
    }

    @Override
    public List<CommentDto> getByPostId(Long id) {
        return commentRepo.getByPostId(id).stream().map(commentMapper::toDto).toList();
    }

    @Override
    public List<CommentDto> getByUserId(Long id) {
        return commentRepo.getByUserId(id).stream().map(commentMapper::toDto).toList();
    }

    @Override
    public List<CommentDto> getSpecificComment(Long postId, Long userId) {
        return commentRepo.getSpecificComment(postId, userId).stream().map(commentMapper::toDto).toList();
    }
}
