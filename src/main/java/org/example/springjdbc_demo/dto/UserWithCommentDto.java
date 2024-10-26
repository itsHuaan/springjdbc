package org.example.springjdbc_demo.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class UserWithCommentDto {
    private Long userId;
    private String username;
    private String name;
    private String comment;
}
