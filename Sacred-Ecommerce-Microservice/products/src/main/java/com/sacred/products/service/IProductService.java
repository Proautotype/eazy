package com.sacred.products.service;

import com.sacred.products.dto.ProductDto;
import com.sacred.products.dto.responses.PageResponse;
import com.sacred.products.dto.searches.ProductSearches;

import java.util.List;

public interface IProductService {

    /**
     * @param productDto - type ProductDto
     * used to create product
     * */
    void addProduct(ProductDto productDto);


    /**
     * @param productId - type String
     * used to fetch product by id
     * @return ProductDto
     * */
    ProductDto fetchProduct(Long productId);


    /**
     * @param productDto - type String
     * used to update product by id
     * @return boolean
     * */
    boolean updateProduct(ProductDto productDto);

    /**
     * @param productId - type String
     * used to delete product by id
     * @return boolean
     * */
    boolean deleteProduct(Long productId);

    /**
     * @param productSearches - type ProductSearches
     * Fetch products and paginate
     * @return boolean
     * */
    PageResponse<ProductDto> filterProducts(ProductSearches productSearches);

}
