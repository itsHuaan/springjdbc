package org.example.springjdbc_demo.entities;

import lombok.*;

import java.sql.Timestamp;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class ReplyEntity {
    private Long replyId;
    private Long commentId;
    private Long userId;
    private String reply;
    private Timestamp createdAt;
}
