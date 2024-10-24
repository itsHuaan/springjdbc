package org.example.springjdbc_demo.mappers.row_mapper;

import org.example.springjdbc_demo.entities.UserEntity;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserRowMapper implements RowMapper<UserEntity> {
    @Override
    public UserEntity mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new UserEntity(
                rs.getLong(1),
                rs.getString(2),
                rs.getString(3),
                rs.getBoolean(4)
        );
    }
}
