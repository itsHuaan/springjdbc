package org.example.springjdbc_demo.mappers.entity_mapper.impl;

import org.example.springjdbc_demo.dto.EmployeeDto;
import org.example.springjdbc_demo.entities.EmployeeEntity;
import org.example.springjdbc_demo.mappers.entity_mapper.IBaseEntityMapper;
import org.example.springjdbc_demo.models.EmployeeModel;
import org.springframework.stereotype.Component;

@Component
public class EmployeeMapper implements IBaseEntityMapper<EmployeeDto, EmployeeEntity, EmployeeModel> {

    @Override
    public EmployeeDto toDto(EmployeeEntity employeeEntity) {
        return EmployeeDto.builder()
                .id(employeeEntity.getId())
                .firstName(employeeEntity.getFirstName())
                .lastName(employeeEntity.getLastName())
                .build();
    }

    @Override
    public EmployeeEntity toEntity(EmployeeModel employeeModel) {
        return EmployeeEntity.builder()
                .id(employeeModel.getId())
                .firstName(employeeModel.getFirstName())
                .lastName(employeeModel.getLastName())
                .build();
    }
}
