package org.example.springjdbc_demo.entities;

import lombok.*;

import java.sql.Timestamp;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class CommentEntity {
    private Long commentId;
    private Long userId;
    private Long postId;
    private String comment;
    private Timestamp createdAt;
}
