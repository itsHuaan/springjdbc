package org.example.springjdbc_demo.models;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class ReplyModel {
    private Long replyId;
    private Long commentId;
    private Long userId;
    private String reply;
    private LocalDateTime createdAt;
}
