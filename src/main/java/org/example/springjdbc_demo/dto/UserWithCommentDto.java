package org.example.springjdbc_demo.dto;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class UserWithCommentDto {
    private Long commentId;
    private Long userId;
    private String username;
    private String name;
    private String comment;
    private List<ReplyDto> replies = new ArrayList<>();
}
