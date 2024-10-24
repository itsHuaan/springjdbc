package org.example.springjdbc_demo.services;

import org.example.springjdbc_demo.dto.EmployeeDto;
import org.example.springjdbc_demo.models.EmployeeModel;

public interface IEmployeeService extends IBaseService<EmployeeDto, EmployeeModel, Long> {
}
