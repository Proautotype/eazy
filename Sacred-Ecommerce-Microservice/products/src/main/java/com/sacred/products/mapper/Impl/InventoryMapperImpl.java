package com.sacred.products.mapper.Impl;

import com.sacred.products.dto.InventoryDto;
import com.sacred.products.mapper.IInventoryMapper;
import com.sacred.products.entity.Inventory;

public class InventoryMapperImpl implements IInventoryMapper {
    /**
     * @param inventoryDto
     * @param inventory
     * @return Inventory
     */
    public static Inventory mapToInventory(InventoryDto inventoryDto, Inventory inventory) {
        inventory.setInventoryStatus(inventoryDto.getInventoryStatus());
        inventory.setQuantity(inventoryDto.getQuantity());
        inventory.setProduct(inventoryDto.getProduct());
        return inventory;
    }

    /**
     * @param inventory
     * @param inventoryDto
     * @return InventoryDto
     */
    public static InventoryDto mapToInventoryDto(Inventory inventory, InventoryDto inventoryDto) {
        inventoryDto.setId(inventoryDto.getId());
        inventoryDto.setInventoryStatus(inventory.getInventoryStatus());
        inventoryDto.setQuantity(inventory.getQuantity());
        inventoryDto.setProduct(inventory.getProduct());
        return null;
    }
}
