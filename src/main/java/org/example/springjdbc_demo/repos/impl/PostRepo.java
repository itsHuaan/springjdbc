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
    @Autowired
    private final JdbcTemplate jdbcTemplate;

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
        return 0;
    }

    @Override
    public int delete(Long id) {
        return 0;
    }
}
