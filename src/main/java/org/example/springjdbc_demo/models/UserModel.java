package org.example.springjdbc_demo.models;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class UserModel {
    private Long userId;
    private String username;
    private String name;
    private Boolean status;
}
