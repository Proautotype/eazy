package com.sacred.products.dto.extensions;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;


@Data
public class BaseCategoryDto {
    @Schema(description = "category name", example = "phones")
    private String name;

    @Schema(description = "category description", example = "mobile phones and accessories")
    private String description;

}
