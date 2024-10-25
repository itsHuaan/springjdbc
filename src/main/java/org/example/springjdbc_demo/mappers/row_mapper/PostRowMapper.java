package org.example.springjdbc_demo.mappers.row_mapper;

import org.example.springjdbc_demo.entities.PostEntity;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PostRowMapper implements RowMapper<PostEntity> {
    @Override
    public PostEntity mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new PostEntity(
                rs.getLong(1),
                rs.getString(2),
                rs.getString(3),
                rs.getTimestamp(4),
                rs.getBoolean(5));
    }
}
