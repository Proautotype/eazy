package com.sacred.products.dto.extensions;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class BaseProductDto {

    @Schema(description = "product's id", example = "12411")
    private Long id;

    @NotEmpty
    @Schema(example = "Samsung A15")
    private String name;

    @NotEmpty
    @Schema(example = "Brand new samsung A15")
    private String description;

    @NotNull
    @Schema(example = "1_000")
    private BigDecimal price;

    @NotNull
    @Schema(example = "12")
    private int quantity;

}
