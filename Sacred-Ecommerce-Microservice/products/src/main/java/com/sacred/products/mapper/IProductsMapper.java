package com.sacred.products.mapper;

import com.sacred.products.dto.ProductDto;
import com.sacred.products.entity.Product;
import org.springframework.stereotype.Service;

public interface IProductsMapper {

    /**
     * @param (productDto | product)
     * @return Product
     */
    static Product mapToProduct(ProductDto productDto, Product product) {
        return null;
    }

    /**
     * @param (product | productDto)
     * @return ProductDto
     */
    static ProductDto mapToProductDto(Product product, ProductDto productDto) {
        return null;
    }
}
