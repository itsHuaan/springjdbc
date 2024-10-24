package org.example.springjdbc_demo.mappers.row_mapper;

import org.example.springjdbc_demo.entities.EmployeeEntity;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;


public class EmployeeRowMapper implements RowMapper<EmployeeEntity> {
    @Override
    public EmployeeEntity mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new EmployeeEntity(
                rs.getLong(1),
                rs.getString(2),
                rs.getString(3)
        );
    }
}
