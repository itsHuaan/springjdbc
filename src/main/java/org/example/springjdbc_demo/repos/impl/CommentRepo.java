package org.example.springjdbc_demo.repos.impl;

import org.example.springjdbc_demo.entities.CommentEntity;
import org.example.springjdbc_demo.mappers.row_mapper.CommentRowMapper;
import org.example.springjdbc_demo.repos.ICommentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CommentRepo implements ICommentRepo {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public CommentRepo(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<CommentEntity> getAll() {
        String query = "select * from tbl_comment";
        return jdbcTemplate.query(query, new CommentRowMapper());
    }

    @Override
    public CommentEntity getById(Long id) {
        return null;
    }

    @Override
    public int save(CommentEntity commentEntity) {
        return 0;
    }

    @Override
    public int delete(Long id) {
        return 0;
    }

    @Override
    public List<CommentEntity> getByPostId(Long id) {
        String query = "select * from tbl_comment where postId = ?";
        return jdbcTemplate.query(query, new CommentRowMapper(), id);
    }

    @Override
    public List<CommentEntity> getByUserId(Long id) {
        String query = "select * from tbl_comment where userId = ?";
        return jdbcTemplate.query(query, new CommentRowMapper(), id);
    }

    @Override
    public CommentEntity getSpecificComment(CommentEntity comment) {
        String query = "select * from tbl_comment where postId = ? and userId = ?";
        return jdbcTemplate.queryForObject(query, new CommentRowMapper(), comment.getPostId(), comment.getUserId());
    }
}
