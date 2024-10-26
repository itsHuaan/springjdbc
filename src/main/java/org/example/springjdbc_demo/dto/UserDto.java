package org.example.springjdbc_demo.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class UserDto {
    private Long userId;
    private String username;
    private String name;
//    private Boolean status;
}
