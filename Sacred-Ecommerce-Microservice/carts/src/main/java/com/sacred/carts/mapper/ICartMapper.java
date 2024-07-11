package com.sacred.carts.mapper;

import com.sacred.carts.dto.CartsDto;
import com.sacred.carts.entity.Cart;

public interface ICartMapper {

     static CartsDto mapToCartDto(Cart cart, CartsDto cartsDto) {
        return null;
    }

    static Cart mapToCart(CartsDto cartsDto, Cart cart){
         return  null;
    }

}
