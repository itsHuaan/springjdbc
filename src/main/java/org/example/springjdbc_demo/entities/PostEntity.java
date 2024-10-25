package org.example.springjdbc_demo.entities;

import lombok.*;

import java.sql.Timestamp;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class PostEntity {
    private Long postId;
    private String title;
    private String content;
    private Timestamp createdAt;
    private boolean status;
}
