package com.sacred.carts.repository.spec;

import com.sacred.carts.entity.Cart;
import org.springframework.data.jpa.domain.Specification;

public class CartSpecification {
    public static Specification<Cart> ofUser(Long userId){
        return (cartRoot, criteriaQuery, criteriaBuilder)-> criteriaBuilder.equal(cartRoot.get("userId"), userId);
    }

    public static Specification<Cart> hasProduct(Long productId){
        return (cartRoot, criteriaQuery, criteriaBuilder)-> criteriaBuilder.equal(cartRoot.get("productId"), productId);
    }
}
