package org.example.springjdbc_demo.repos;

import org.example.springjdbc_demo.entities.PostEntity;

public interface IPostRepo extends IBaseRepo<PostEntity, Long> {
    int dropALike(Long postId);
}
