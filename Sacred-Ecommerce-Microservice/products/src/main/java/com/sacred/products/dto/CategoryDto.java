package com.sacred.products.dto;

import com.sacred.products.dto.extensions.BaseCategoryDto;
import com.sacred.products.entity.Product;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@Schema(name = "Category", description = "Schema to hold Category information")
public class CategoryDto extends BaseCategoryDto {

    private Long id;

    @Schema(description = "Products in the category")
    private List<Product> products;
}
