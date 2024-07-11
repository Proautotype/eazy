package com.sacred.ordermanagement.exceptions

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ResponseStatus

@ResponseStatus(value = HttpStatus.NOT_FOUND)
class ResourceNotFoundException(
        private val resourceName: String,
        private val fieldName: String,
        private val value: String
): RuntimeException("$resourceName not found by $fieldName with given value $value")