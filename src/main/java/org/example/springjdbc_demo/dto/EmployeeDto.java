package org.example.springjdbc_demo.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class EmployeeDto {
    private Long id;
    private String firstName;
    private String lastName;
}
