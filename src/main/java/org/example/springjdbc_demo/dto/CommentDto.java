package org.example.springjdbc_demo.dto;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class CommentDto {
//    private Long commentId;
    private Long userId;
//    private Long postId;
    private String comment;
    private LocalDateTime createdAt;
}
