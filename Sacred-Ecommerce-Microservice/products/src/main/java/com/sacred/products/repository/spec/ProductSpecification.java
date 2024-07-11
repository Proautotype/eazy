package com.sacred.products.repository.spec;

import com.sacred.products.entity.Product;
import com.sacred.products.entity.Product_;
import org.springframework.data.jpa.domain.Specification;

public class ProductSpecification {

    public static Specification<Product> containsName(String name){
        return (productRoot, criteriaQuery, criteriaBuilder)
                -> {
            if(name == null){
                criteriaBuilder.conjunction();
                return null;
            }
            return criteriaBuilder.like(
                    productRoot.get(Product_.name), "%" +name+"%"
            );
        };
    }

    public static Specification<Product> containDescription(String description){
        return (productRoot, criteriaQuery, criteriaBuilder) -> {
            if(description == null){
                criteriaBuilder.conjunction();
                return null;
            }
            return criteriaBuilder.like(
                    productRoot .get(Product_.description), "%" +description+"%"
            );
        };
    }

    public static Specification<Product> hasMinPrice(Double minPrice){
        return (productRoot, criteriaQuery, criteriaBuilder) -> {
          if(minPrice == null){
              criteriaBuilder.conjunction();
              return null;
          }

          return criteriaBuilder.greaterThanOrEqualTo(
                  productRoot.get(Product_.price), minPrice
          );
        };

    }

    public static Specification<Product> hasMaxPrice(Double maxPrice){
        return (productRoot, criteriaQuery, criteriaBuilder) -> {
            if(maxPrice == null){
                criteriaBuilder.conjunction();
                return null;
            }
            return criteriaBuilder.lessThanOrEqualTo(
                    productRoot.get(Product_.price), maxPrice
            );
        };

    }


}
