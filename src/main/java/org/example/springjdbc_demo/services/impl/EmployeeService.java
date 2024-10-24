package org.example.springjdbc_demo.services.impl;

import org.example.springjdbc_demo.dto.EmployeeDto;
import org.example.springjdbc_demo.models.EmployeeModel;
import org.example.springjdbc_demo.services.IEmployeeService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService implements IEmployeeService {

    @Override
    public List<EmployeeDto> getAll() {
        return List.of();
    }

    @Override
    public EmployeeDto getById(Long id) {
        return null;
    }

    @Override
    public int save(EmployeeModel employeeModel) {
        return 0;
    }

    @Override
    public int delete(Long id) {
        return 0;
    }
}
