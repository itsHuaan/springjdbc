package org.example.springjdbc_demo.mappers.row_mapper;

import org.example.springjdbc_demo.entities.CommentEntity;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CommentRowMapper implements RowMapper<CommentEntity> {
    @Override
    public CommentEntity mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new CommentEntity(
                rs.getLong(1),
                rs.getLong(2),
                rs.getString(3),
                rs.getTimestamp(4)
        );
    }
}
