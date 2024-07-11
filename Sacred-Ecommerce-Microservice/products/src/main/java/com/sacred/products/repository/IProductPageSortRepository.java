package com.sacred.products.repository;

import com.sacred.products.entity.Product;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProductPageSortRepository extends PagingAndSortingRepository<Product, Long> {
}
