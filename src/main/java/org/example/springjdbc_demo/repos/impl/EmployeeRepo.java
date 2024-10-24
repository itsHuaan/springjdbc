package org.example.springjdbc_demo.repos.impl;

import org.example.springjdbc_demo.entities.EmployeeEntity;
import org.example.springjdbc_demo.mappers.row_mapper.EmployeeRowMapper;
import org.example.springjdbc_demo.repos.IEmployeeRepo;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeRepo implements IEmployeeRepo {
    private final JdbcTemplate jdbcTemplate;

    public EmployeeRepo(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<EmployeeEntity> getAll() {
        String query = "select * from tbl_employee";
        return jdbcTemplate.query(query, new EmployeeRowMapper());
    }

    @Override
    public EmployeeEntity getById(Long id) {
        String query = "select * from tbl_employee where id = ?";
        return jdbcTemplate.queryForObject(query, new EmployeeRowMapper(), id);
    }

    @Override
    public int save(EmployeeEntity employeeEntity) {
        boolean isExist = getById(employeeEntity.getId()) != null;
        if (isExist) {
            String query = "update tbl_employee set fistName = ?, lastName = ? where id = ?";
            jdbcTemplate.update(query, employeeEntity.getFirstName(), employeeEntity.getLastName(), employeeEntity.getId());
            return 1;
        } else {
            String query = "insert into tbl_employee (fistName, lastName) values (?, ?)";
            jdbcTemplate.update(query, employeeEntity.getFirstName(), employeeEntity.getLastName());
            return 2;
        }
    }

    @Override
    public int delete(Long id) {
        String query = "delete from tbl_employee where id = ?";
        if (jdbcTemplate.update(query, id) > 0) {
            return 1;
        } else {
            return 0;
        }
    }
}
