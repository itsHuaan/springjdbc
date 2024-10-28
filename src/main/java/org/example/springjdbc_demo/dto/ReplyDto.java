package org.example.springjdbc_demo.dto;

import lombok.*;

import java.sql.Timestamp;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class ReplyDto {
    private Long replyId;
    private String username;
    private String name;
    private String reply;
    private Timestamp createdAt;
}
