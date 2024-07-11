package com.sacred.products.repository;

import com.sacred.products.entity.Inventory;
import com.sacred.products.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IInventoryRepository extends JpaRepository<Inventory, Long> {

    Optional<Inventory> findByProduct(Product id);
}
