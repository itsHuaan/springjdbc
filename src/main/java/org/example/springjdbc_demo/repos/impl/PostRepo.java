package org.example.springjdbc_demo.repos.impl;

import org.example.springjdbc_demo.entities.PostEntity;
import org.example.springjdbc_demo.mappers.row_mapper.PostRowMapper;
import org.example.springjdbc_demo.repos.IPostRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PostRepo implements IPostRepo {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public PostRepo(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<PostEntity> getAll() {
        String query = "select * from tbl_post where status = 1";
        return jdbcTemplate.query(query, new PostRowMapper());
    }

    @Override
    public PostEntity getById(Long id) {
        String query = "select * from tbl_post where postId = ?";
        return jdbcTemplate.queryForObject(query, new PostRowMapper(), id);
    }

    @Override
    public int save(PostEntity postEntity) {
        boolean isExisting = getById(postEntity.getPostId()) != null;
        if (isExisting) {
            String query = "update tbl_post set title = ?, content = ?, createdAt = ?, status = ? where postId = ?";
            jdbcTemplate.update(query, new PostRowMapper(),
                    postEntity.getTitle(),
                    postEntity.getContent(),
                    postEntity.getCreatedAt(),
                    postEntity.getPostId());
            return 2;
        } else {
            String query = "insert into tbl_post (title, content, createdAt, status) values (?, ?, ?, ?)";
            jdbcTemplate.update(query, new PostRowMapper(),
                    postEntity.getTitle(),
                    postEntity.getContent(),
                    postEntity.getCreatedAt());
            return 1;
        }
    }

    @Override
    public int delete(Long id) {
        String query = "delete from tbl_post where postId = ?";
        jdbcTemplate.update(query, new PostRowMapper(), id);
        return 0;
    }

    @Override
    public int dropALike(Long postId) {
        String query = "update tbl_post set likes = likes + 1 where postId = ?";
        jdbcTemplate.update(query, postId);
        return 3;
    }
}
