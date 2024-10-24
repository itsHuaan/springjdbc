package org.example.springjdbc_demo.entities;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class UserEntity {
    private Long userId;
    private String username;
    private String name;
    private Boolean status;
}
