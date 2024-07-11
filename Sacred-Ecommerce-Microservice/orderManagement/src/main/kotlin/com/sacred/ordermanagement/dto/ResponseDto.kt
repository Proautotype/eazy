package com.sacred.ordermanagement.dto

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ResponseStatus

data class ResponseDto(val message: String, val responseCode: HttpStatus)
