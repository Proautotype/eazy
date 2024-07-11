package com.sacred.products.mapper.Impl;

import com.sacred.products.dto.CategoryDto;
import com.sacred.products.dto.extensions.BaseCategoryDto;
import com.sacred.products.mapper.ICategoryMapper;
import com.sacred.products.entity.Category;
import org.springframework.stereotype.Service;

@Service
public class CategoryMapperImpl implements ICategoryMapper {
    /**
     * @param categoryDto
     * @param category
     * @return Category
     */
    public static Category mapToCategory(BaseCategoryDto categoryDto, Category category) {
        category.setName(categoryDto.getName());
        category.setDescription(categoryDto.getDescription());
        return category;
    }

    /**
     * @param category
     * @param categoryDto
     * @return CategoryDto
     */
    public static CategoryDto mapToCategoryDto(Category category, CategoryDto categoryDto) {
        categoryDto.setId(category.getId());
        categoryDto.setName(category.getName());
        categoryDto.setDescription(category.getDescription());
        categoryDto.setProducts(category.getProducts());
        return null;
    }
}
