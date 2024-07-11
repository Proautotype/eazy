package com.sacred.products.service;

import com.sacred.products.dto.CategoryDto;
import com.sacred.products.dto.ProductDto;
import com.sacred.products.dto.extensions.BaseCategoryDto;

public interface ICategoryService {
    /**
     * @param categoryDto - type CategoryDto
     * used to create category
     * */
    void addCategory(BaseCategoryDto categoryDto);


    /**
     * @param categoryId - type String
     * used to fetch category by id
     * @return CategoryDto
     * */
    ProductDto fetchCategory(String categoryId);


    /**
     * @param categoryDto - type CategoryDto
     * used to update category
     * @return boolean
     * */
    boolean updateCategory(CategoryDto categoryDto);

    /**
     * @param categoryId - type String
     * used to delete category
     * @return boolean
     * */
    boolean deleteCategory(String categoryId);
}
