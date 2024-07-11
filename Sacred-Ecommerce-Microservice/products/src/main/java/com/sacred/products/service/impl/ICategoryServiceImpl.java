package com.sacred.products.service.impl;

import com.sacred.products.dto.CategoryDto;
import com.sacred.products.dto.ProductDto;
import com.sacred.products.dto.extensions.BaseCategoryDto;
import com.sacred.products.entity.Category;
import com.sacred.products.exception.CategoryAlreadyExistException;
import com.sacred.products.exception.ResourceNotFoundException;
import com.sacred.products.mapper.Impl.CategoryMapperImpl;
import com.sacred.products.repository.ICategoryRepository;
import com.sacred.products.service.ICategoryService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ICategoryServiceImpl implements ICategoryService {

    private final ICategoryRepository icategoryRepository;

    public ICategoryServiceImpl(ICategoryRepository icategoryRepository) {
        this.icategoryRepository = icategoryRepository;
    }

    /**
     * @param categoryDto - type CategoryDto
     *                    used to create category
     */
    @Override
    public void addCategory(BaseCategoryDto categoryDto) {
        Category category = CategoryMapperImpl.mapToCategory(categoryDto, new Category());
        Optional<Category> optionalCategory = icategoryRepository.findByName(categoryDto.getName());
        if(optionalCategory.isPresent()){
            throw new CategoryAlreadyExistException("Category", "name", categoryDto.getName());
        }
        icategoryRepository.save(category);
    }

    /**
     * @param categoryId - type String
     *                   used to fetch category by id
     * @return CategoryDto
     */
    @Override
    public ProductDto fetchCategory(String categoryId) {
        return null;
    }

    /**
     * @param categoryDto - type CategoryDto
     *                    used to update category
     * @return boolean
     */
    @Override
    public boolean updateCategory(CategoryDto categoryDto) {
        return false;
    }

    /**
     * @param categoryId - type String
     *                   used to delete category
     * @return boolean
     */
    @Override
    public boolean deleteCategory(String categoryId) {
        return false;
    }
}
