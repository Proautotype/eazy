package com.sacred.products.service.impl;

import com.sacred.products.dto.InventoryDto;
import com.sacred.products.service.IInventoryService;
import org.springframework.stereotype.Service;

@Service
public class InventoryServiceImpl implements IInventoryService {
    /**
     * @param inventoryDto - type InventoryDto
     *                     used to create inventory
     */
    @Override
    public void addInventory(InventoryDto inventoryDto) {

    }

    /**
     * @param inventoryId - type String
     *                    used to fetch inventory by id
     * @return InventoryDto
     */
    @Override
    public InventoryDto fetchInventory(String inventoryId) {
        return null;
    }

    /**
     * @param inventoryDto - type String
     *                     used to update inventory by id
     * @return boolean
     */
    @Override
    public boolean updateInventory(InventoryDto inventoryDto) {
        return false;
    }

    /**
     * @param inventoryId - type String
     *                    used to delete inventory by id
     * @return boolean
     */
    @Override
    public boolean deleteInventory(String inventoryId) {
        return false;
    }
}
