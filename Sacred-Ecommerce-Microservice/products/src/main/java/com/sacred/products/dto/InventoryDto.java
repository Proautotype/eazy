package com.sacred.products.dto;

import com.sacred.products.constants.InventoryStatus;
import com.sacred.products.dto.extensions.BaseInventoryDto;
import com.sacred.products.entity.Product;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;


@EqualsAndHashCode(callSuper = true)
@Data
@Schema(name = "Inventory", description = "Schema to hold inventory information")
public class InventoryDto  extends BaseInventoryDto {
    @Schema(description = "An enum describing the status of the product, IN_STOCK, OUT_OF_STOCK, NEEDS_REPLENISHMENT")
    private InventoryStatus inventoryStatus;
}
