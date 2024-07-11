package com.sacred.ordermanagement.exceptions

import com.sacred.ordermanagement.dto.ErrorResponseDto
import org.springframework.http.HttpStatus
import org.springframework.http.HttpStatusCode
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.context.request.WebRequest
import java.time.LocalDateTime

@ControllerAdvice
class GlobalExceptions {

    @ExceptionHandler(Exception::class)
    fun globalExceptionHandler(ex: Exception, request: WebRequest): ResponseEntity<ErrorResponseDto>{
        val errorResponseDto  = ErrorResponseDto(
                request.getDescription(false),
                HttpStatus.INTERNAL_SERVER_ERROR,
                ex.message,
                LocalDateTime.now()
        )

        return ResponseEntity(errorResponseDto, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(ResourceNotFoundException::class)
    fun handleResponseNotFoundException(
            ex: ResourceNotFoundException,
            request: WebRequest
    ):ResponseEntity<ErrorResponseDto>{
        val errorResponseDto  = ErrorResponseDto(
                request.getDescription(false),
                HttpStatus.NOT_FOUND,
                ex.message,
                LocalDateTime.now()
        )

        return ResponseEntity(errorResponseDto, HttpStatus.NOT_FOUND);

    }

}