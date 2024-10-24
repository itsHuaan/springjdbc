package org.example.springjdbc_demo.dto;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class PostDto {
//    private Long postId;
    private String title;
    private String content;
    private Long commentId;
    private LocalDateTime createdAt;
}
