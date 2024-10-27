package org.example.springjdbc_demo.models;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class CommentModel {
    private Long commentId;
    private Long userId;
    private Long postId;
    private String comment;
    private LocalDateTime createdAt = LocalDateTime.now();
}
