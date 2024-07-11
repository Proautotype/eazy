package com.sacred.products.service;


import com.sacred.products.dto.InventoryDto;

public interface IInventoryService {
    /**
     * @param inventoryDto - type InventoryDto
     * used to create inventory
     * */
    void addInventory(InventoryDto inventoryDto);


    /**
     * @param inventoryId - type String
     * used to fetch inventory by id
     * @return InventoryDto
     * */
    InventoryDto fetchInventory(String inventoryId);


    /**
     * @param inventoryDto - type String
     * used to update inventory by id
     * @return boolean
     * */
    boolean updateInventory(InventoryDto inventoryDto);

    /**
     * @param inventoryId - type String
     * used to delete inventory by id
     * @return boolean
     * */
    boolean deleteInventory(String inventoryId);
}
