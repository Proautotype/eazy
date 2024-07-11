package com.sacred.products.dto.responses;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.ACCEPTED)
@Data
@AllArgsConstructor
@Schema(description = "Schema to hold response ")
public class ResponseDto {

    @Schema(description = "Http response status")
    private HttpStatus status;

    @Schema(description = "Http response message")
    private String message;
}
