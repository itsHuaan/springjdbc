package org.example.springjdbc_demo.repos.impl;

import org.example.springjdbc_demo.entities.PostEntity;
import org.example.springjdbc_demo.repos.IPostRepo;

import java.util.List;

public class PostRepo implements IPostRepo {
    @Override
    public List<PostEntity> getAll() {
        return List.of();
    }

    @Override
    public PostEntity getById(Long aLong) {
        return null;
    }

    @Override
    public int save(PostEntity postEntity) {
        return 0;
    }

    @Override
    public int delete(Long aLong) {
        return 0;
    }
}
