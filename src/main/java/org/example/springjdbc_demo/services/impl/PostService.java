package org.example.springjdbc_demo.services.impl;

import org.example.springjdbc_demo.dto.PostDto;
import org.example.springjdbc_demo.dto.UserWithCommentDto;
import org.example.springjdbc_demo.entities.PostEntity;
import org.example.springjdbc_demo.mappers.entity_mapper.impl.PostMapper;
import org.example.springjdbc_demo.models.PostModel;
import org.example.springjdbc_demo.repos.impl.PostRepo;
import org.example.springjdbc_demo.repos.impl.UserRepo;
import org.example.springjdbc_demo.services.IPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PostService implements IPostService {
    private final PostRepo postRepo;
    private final UserRepo userRepo;
    private final PostMapper postMapper;

    @Autowired
    public PostService(PostRepo postRepo, UserRepo userRepo, PostMapper postMapper) {
        this.postRepo = postRepo;
        this.userRepo = userRepo;
        this.postMapper = postMapper;
    }

    @Override
    public List<PostDto> getAll() {
        return postRepo.getAll().stream()
                .map(postEntity -> {
                    List<UserWithCommentDto> comments = userRepo.getByPostId(postEntity.getPostId());
                    PostDto postDto = postMapper.toDto(postEntity);
                    postDto.setComments(comments);
                    return postDto;
                }).toList();
    }

    @Override
    public PostDto getById(Long id) {
        PostEntity postEntity = postRepo.getById(id);
        List<UserWithCommentDto> comments = userRepo.getByPostId(id);
        PostDto postDto = postMapper.toDto(postEntity);
        postDto.setComments(comments);
        return postDto;
    }

    @Override
    public int save(PostModel postModel) {
        return 0;
    }

    @Override
    public int delete(Long id) {
        return 0;
    }
}
