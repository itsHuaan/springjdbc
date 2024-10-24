package org.example.springjdbc_demo.repos.impl;

import org.example.springjdbc_demo.entities.CommentEntity;
import org.example.springjdbc_demo.repos.ICommentRepo;

import java.util.List;

public class CommentRepo implements ICommentRepo {
    @Override
    public List<CommentEntity> getAll() {
        return List.of();
    }

    @Override
    public CommentEntity getById(Long aLong) {
        return null;
    }

    @Override
    public int save(CommentEntity commentEntity) {
        return 0;
    }

    @Override
    public int delete(Long aLong) {
        return 0;
    }
}
