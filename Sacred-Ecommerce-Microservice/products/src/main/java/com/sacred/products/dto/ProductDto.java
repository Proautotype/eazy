package com.sacred.products.dto;

import com.sacred.products.dto.extensions.BaseProductDto;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;

@EqualsAndHashCode(callSuper = true)
@Data
@Schema(name = "Product", description = "Schema to hold Product information")
public class ProductDto extends BaseProductDto {

    @Schema(description = "Category the product is associated")
    private Long category;
}
