package com.sacred.products.dto.extensions;

import com.sacred.products.entity.Product;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class BaseInventoryDto {
    @Schema(description = "Inventory id", example = "25210")
    private Long id;

    @Schema(description = "Product joined to this inventory")
    private Product product;

    @Schema(description = "Number of products in stock")
    private int quantity;
}
