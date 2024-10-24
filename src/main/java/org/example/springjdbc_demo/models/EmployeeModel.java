package org.example.springjdbc_demo.models;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class EmployeeModel {
    private Long id;
    private String firstName;
    private String lastName;
}
