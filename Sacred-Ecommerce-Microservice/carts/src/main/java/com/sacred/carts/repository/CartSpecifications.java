package com.sacred.carts.repository;

import com.sacred.carts.entity.Cart;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.data.jpa.domain.Specification;

public class CartSpecifications {

    public static Specification<Cart> userIdEqual(Long userId){
        return (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("userId"), userId);
    }

    public static Specification<Cart> fetchLimitedCartItems(int limit){
        final String cartItemColumn = "cartItems" ;
        return  (root,query,criteriaBuilder) -> {
            root.fetch(cartItemColumn);
            query.distinct(true);
            query.orderBy(
                    criteriaBuilder.asc(
                            root.get(cartItemColumn).get("id")
                    )
            );

            return criteriaBuilder.conjunction();
        };
    }

}
