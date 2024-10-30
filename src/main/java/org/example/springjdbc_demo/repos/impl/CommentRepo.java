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
        String query = "select * from tbl_comment where commentId = ?";
        return jdbcTemplate.queryForObject(query, new CommentRowMapper(), id);
    }

    @Override
    public int save(CommentEntity commentEntity) {
        if (commentEntity.getCommentId() != null) {
            boolean isExisting = getById(commentEntity.getCommentId()) != null;
            if (isExisting) {
                String query = "update tbl_comment set comment = ? where commentId = ?";
                jdbcTemplate.update(query, commentEntity.getComment(), commentEntity.getCommentId());
                return 2;
            } else {
                String query = "insert into tbl_comment (userId, postId, comment) values (?, ?, ?)";
                jdbcTemplate.update(query, commentEntity.getUserId(), commentEntity.getPostId(), commentEntity.getComment());
                return 1;
            }
        } else {
            String query = "insert into tbl_comment (userId, postId, comment) values (?, ?, ?)";
            jdbcTemplate.update(query, commentEntity.getUserId(), commentEntity.getPostId(), commentEntity.getComment());
            return 1;
        }
    }

    @Override
    public int delete(Long id) {
        String query = "delete from tbl_comment where commentId = ?";
        return jdbcTemplate.update(query, new JdbcTemplate(), id);
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
    public List<CommentEntity> getSpecificComment(Long postId, Long userId) {
        String query = "select * from tbl_comment where postId = ? and userId = ?";
        return jdbcTemplate.query(query, new CommentRowMapper(), postId, userId);
    }
}
