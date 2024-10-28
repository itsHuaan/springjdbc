package org.example.springjdbc_demo.mappers.row_mapper;

import org.example.springjdbc_demo.entities.ReplyEntity;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ReplyRowMapper implements RowMapper<ReplyEntity> {
    @Override
    public ReplyEntity mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new ReplyEntity(
                rs.getLong(1),
                rs.getLong(2),
                rs.getLong(3),
                rs.getString(4),
                rs.getTimestamp(5)
        );
    }
}
