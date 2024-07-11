package com.sacred.products.mapper.Impl;

import com.sacred.products.dto.ProductDto;
import com.sacred.products.dto.extensions.BaseProductDto;
import com.sacred.products.mapper.IProductsMapper;
import com.sacred.products.entity.Product;

public class ProductMapperImpl implements IProductsMapper {

    /**
     * @param productDto
     * @param product
     * @return Product
     */

    public static Product mapToProduct(BaseProductDto productDto, Product product) {
        product.setName(productDto.getName());
        product.setDescription(productDto.getDescription());
        product.setPrice(productDto.getPrice());
        return product;
    }

    /**
     * @param product
     * @param productDto
     * @return ProductDto
     */

    public static ProductDto mapToProductDto(Product product, ProductDto productDto) {
        productDto.setId(product.getId());
        productDto.setName(product.getName());
        productDto.setDescription(product.getDescription());
        productDto.setPrice(product.getPrice());
        productDto.setCategory(product.getCategory().getId());
        return productDto;
    }
}
