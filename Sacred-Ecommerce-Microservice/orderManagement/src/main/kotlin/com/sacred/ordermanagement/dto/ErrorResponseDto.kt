package com.sacred.ordermanagement.dto

import org.springframework.http.HttpStatus
import java.time.LocalDateTime

data class ErrorResponseDto(
        val apiPath: String,
        val httpStatus: HttpStatus,
        val message: String?,
        val timeStamp: LocalDateTime?
)
