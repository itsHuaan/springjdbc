package org.example.springjdbc_demo.repos.impl;

import org.example.springjdbc_demo.dto.UserWithCommentDto;
import org.example.springjdbc_demo.entities.UserEntity;
import org.example.springjdbc_demo.mappers.entity_mapper.impl.UserMapper;
import org.example.springjdbc_demo.mappers.row_mapper.UserRowMapper;
import org.example.springjdbc_demo.repos.IUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserRepo implements IUserRepo {
    private final JdbcTemplate jdbcTemplate;
    private final ReplyRepo replyRepo;

    @Autowired
    public UserRepo(JdbcTemplate jdbcTemplate, ReplyRepo replyRepo) {
        this.jdbcTemplate = jdbcTemplate;
        this.replyRepo = replyRepo;
    }

    @Override
    public List<UserEntity> getAll() {
        String query = "select * from tbl_user where status = 1";
        return jdbcTemplate.query(query, new UserRowMapper());
    }

    @Override
    public UserEntity getById(Long id) {
        String query = "select * from tbl_user where userId = ?";
        try {
            return jdbcTemplate.queryForObject(query, new UserRowMapper(), id);
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    @Override
    public int save(UserEntity userEntity) {
        boolean isExisting = getById(userEntity.getUserId()) != null;
        if (isExisting) {
            String query = "update tbl_user set username = ?, name = ?, status = ? where userId = ?";
            jdbcTemplate.update(
                    query,
                    userEntity.getUsername(),
                    userEntity.getName(),
                    userEntity.getStatus(),
                    userEntity.getUserId());
            return 2;
        } else {
            String query = "insert into tbl_user (username, name, status) values (?, ?, ?)";
            jdbcTemplate.update(query, userEntity.getUsername(), userEntity.getName(), userEntity.getStatus());
            return 1;
        }
    }

    @Override
    public int delete(Long id) {
        String query = "update tbl_user set status = 0 where userId = ?";
        return jdbcTemplate.update(query, id);
    }

    @Override
    public List<UserWithCommentDto> getByPostId(Long postId) {
        String query = "select c.commentId, u.userId, u.username, u.name, c.comment from tbl_comment c join tbl_user u on c.userId = u.userId where c.postId = ?";
        List<UserWithCommentDto> comments = jdbcTemplate.query(query, (rs, rowNum) -> new UserWithCommentDto(
                rs.getLong(1),
                rs.getLong(2),
                rs.getString(3),
                rs.getString(4),
                rs.getString(5),
                null), postId);
        for (UserWithCommentDto comment : comments) {
            comment.setReplies(replyRepo.getByCommentId(comment.getCommentId()));
        }
        return comments;
    }
}
