package com.sacred.carts.dto.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class ErrorResponseDto {
    private String path;
    HttpStatus status;
    private Object message;
    private LocalDateTime dateTime;
}
