package com.sacred.products.mapper;

import com.sacred.products.dto.InventoryDto;
import com.sacred.products.entity.Inventory;

public interface IInventoryMapper {
    /**
     * @param (inventoryDto | inventory)
     * @return Inventory
     */
    static Inventory mapToInventory(InventoryDto inventoryDto, Inventory inventory) {
        return null;
    }

    /**
     * @param (inventory | inventoryDto)
     * @return InventoryDto
     */
    static InventoryDto mapToInventoryDto(Inventory inventory, InventoryDto inventoryDto) {
        return null;
    }
}
