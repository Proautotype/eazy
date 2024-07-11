package com.sacred.products.mapper;

import com.sacred.products.dto.CategoryDto;
import com.sacred.products.entity.Category;

public interface ICategoryMapper {
    /**
     * @param (categoryDto | category)
     * @return Category
     */
    static Category mapToCategory(CategoryDto categoryDto, Category category) {
        return null;
    }

    /**
     * @param (category | categoryDto)
     * @return CategoryDto
     */
    static CategoryDto mapToCategoryDto(Category category, CategoryDto categoryDto) {
        return null;
    }
}
