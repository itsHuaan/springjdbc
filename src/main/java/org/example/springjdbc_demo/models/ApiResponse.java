package org.example.springjdbc_demo.models;

import lombok.*;
import org.springframework.http.HttpStatus;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ApiResponse<T> {
    private String message;
    private T data;
    private HttpStatus status;
}
