package com.sacred.carts.mapper.impl;

import com.sacred.carts.dto.CartItemDto;
import com.sacred.carts.dto.CartsDto;
import com.sacred.carts.dto.extensions.BaseCartDto;
import com.sacred.carts.dto.extensions.BaseCartItemDto;
import com.sacred.carts.entity.Cart;
import com.sacred.carts.entity.CartItem;
import com.sacred.carts.mapper.ICartMapper;

import java.util.List;
import java.util.stream.Stream;

public class CartMapperImpl implements ICartMapper {

    public static CartsDto mapToCartDto(Cart cart, CartsDto cartsDto){
        cartsDto.setId(cart.getId());
        cartsDto.setEmptied(cart.isEmptied());
        cartsDto.setUserId(cart.getUserId());

        List<CartItemDto> cartItemList = cart.getCartItems().stream().map(cartItem -> {
            CartItemDto returningCartItem = new CartItemDto();
            returningCartItem.setId(cartItem.getId());
            returningCartItem.setQuantity(cartItem.getQuantity());
            returningCartItem.setUserId(cartItem.getUserId());
            returningCartItem.setProductId(cartItem.getProductId());
            return returningCartItem;
        }).toList();

        cartsDto.setCartItems(cartItemList);

        return cartsDto;
    }

    public static Cart mapToCart(BaseCartItemDto baseCartItemDto, Cart cart){
        cart.setUserId(baseCartItemDto.getUserId());
        return  cart;
    }

}
