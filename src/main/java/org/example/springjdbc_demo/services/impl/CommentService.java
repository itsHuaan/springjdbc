package org.example.springjdbc_demo.services.impl;

import org.example.springjdbc_demo.dto.CommentDto;
import org.example.springjdbc_demo.models.CommentModel;
import org.example.springjdbc_demo.services.ICommentService;

import java.util.List;

public class CommentService implements ICommentService {
    @Override
    public List<CommentDto> getAll() {
        return List.of();
    }

    @Override
    public CommentDto getById(Long aLong) {
        return null;
    }

    @Override
    public int save(CommentModel commentModel) {
        return 0;
    }

    @Override
    public int delete(Long aLong) {
        return 0;
    }
}
