package org.example.springjdbc_demo.dto;

import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class PostDto {
    private Long postId;
    private String title;
    private String content;
    private int likes;
    private LocalDateTime createdAt;
    private boolean status;
    private List<UserWithCommentDto> comments;
}
