package org.example.springjdbc_demo.repos.impl;

import org.example.springjdbc_demo.dto.ReplyDto;
import org.example.springjdbc_demo.entities.ReplyEntity;
import org.example.springjdbc_demo.repos.IReplyRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ReplyRepo implements IReplyRepo {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public ReplyRepo(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<ReplyEntity> getAll() {
        String query = "select * from tbl_reply";
        return List.of();
    }

    @Override
    public ReplyEntity getById(Long id) {
        return null;
    }

    @Override
    public int save(ReplyEntity replyEntity) {
        String query = "insert into tbl_reply (commentId, userId, reply) values (?, ?, ?)";
        return jdbcTemplate.update(query, replyEntity.getCommentId(), replyEntity.getUserId(), replyEntity.getReply());
    }

    @Override
    public int delete(Long id) {
        return 0;
    }

    @Override
    public List<ReplyDto> getByCommentId(Long id) {
        String query = "select u.userId, u.username, u.name, r.reply, r.createdAt from tbl_reply r join tbl_user u on r.userId = u.userId where r.commentId = ?";
        return jdbcTemplate.query(query, (rs, rowNum) -> new ReplyDto(
                rs.getLong(1),
                rs.getString(2),
                rs.getString(3),
                rs.getString(4),
                rs.getTimestamp(5)), id);
    }
}
