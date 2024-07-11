package com.sacred.ordermanagement.controller

import com.sacred.ordermanagement.dto.ConfigurationDto
import com.sacred.ordermanagement.dto.ResponseDto
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.media.Content
import io.swagger.v3.oas.annotations.media.Schema
import io.swagger.v3.oas.annotations.responses.ApiResponse
import io.swagger.v3.oas.annotations.responses.ApiResponses
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@Tag(
        name = "Order Management REST Apis for Order Management Microservice"
)
@RestController
@RequestMapping("api/v1")
@Validated
class OrderController(val configurationDto:ConfigurationDto) {

    @Operation(summary = "Create Orders REST API", description = "RESP API to create new Orders in Orders Management MS")
    @ApiResponses(
            value = [
                ApiResponse(responseCode = "201", description = "HTTP status Created: Operation successful"),
                ApiResponse(responseCode = "400", description = "HTTP status ResourceAlreadyExist: Operation ResourceAlreadyExist"),
            ]
    )
    @PostMapping("createOrder")
    fun createOrder():ResponseEntity<ResponseDto> {
        return ResponseEntity(null, HttpStatus.OK);
    }

    @Operation(
        summary = "Get contact information",
        description = "Get contact information of the developer that deployed  account microservice"
    )
    @ApiResponses(
        ApiResponse(responseCode = "200", description = "HTTP Status OK"),
        ApiResponse(
            responseCode = "500",
            description = "HTTP Status Internal Server Error",
            content = [
                Content(schema = Schema(implementation = com.sacred.ordermanagement.dto.ErrorResponseDto::class))
            ]
        )
    )
    @GetMapping("/contact-info")
    fun getContactInfo(): ResponseEntity<ConfigurationDto> {
        println("configuration dto -> " + configurationDto.toString())
        return ResponseEntity.status(HttpStatus.OK).body(configurationDto)
    }

}
