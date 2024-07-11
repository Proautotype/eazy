package com.sacred.products.dto.searches;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.MethodArgumentNotValidException;

import java.util.InvalidPropertiesFormatException;

import static com.sacred.products.constants.ProductConstants.DESCRIPTION_REGEX;
import static com.sacred.products.constants.ProductConstants.NAME_REGEX;

@Data
@RequiredArgsConstructor
public class ProductSearches{
    private String name;
    private String description;
    private double minPrice;
    private double maxPrice;
    private int pageNumber;
    private int pageSize;

    public void setName(String name) throws InvalidPropertiesFormatException {
        if(name != null && (!name.matches(NAME_REGEX))){
            throw new InvalidPropertiesFormatException("Product name with value " +name + " failed validation");
        }
    }

    public void setDescription(String description) throws InvalidPropertiesFormatException {
        if(description != null && (!description.matches(DESCRIPTION_REGEX))){
            throw new InvalidPropertiesFormatException("Product description with value " +description + " failed validation");
        }
    }
}