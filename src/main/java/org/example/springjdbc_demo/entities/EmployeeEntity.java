package org.example.springjdbc_demo.entities;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class EmployeeEntity {
    private Long id;
    private String firstName;
    private String lastName;
}
