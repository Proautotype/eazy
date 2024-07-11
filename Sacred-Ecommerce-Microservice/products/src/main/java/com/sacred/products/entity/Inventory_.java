package com.sacred.products.entity;

import com.sacred.products.constants.InventoryStatus;
import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(Inventory.class)
public class Inventory_ {

    public static SingularAttribute<Inventory, Long> id;
    public static SingularAttribute<Inventory, Integer> quantity;

    public static SingularAttribute<Inventory, Product> product;
    public static SingularAttribute<Inventory, InventoryStatus> inventoryStatus;

}
