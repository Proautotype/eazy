package com.sacred.carts.mapper.impl;

import com.sacred.carts.dto.CartItemDto;
import com.sacred.carts.dto.extensions.BaseCartItemDto;
import com.sacred.carts.entity.CartItem;
import com.sacred.carts.mapper.ICartItemMapper;

public class CartItemMapper implements ICartItemMapper {

    //can set id
    public static CartItemDto mapToCartItemDto(CartItem cartItem, CartItemDto cartItemDto){
        cartItemDto.setProductId(cartItem.getProductId());
        cartItemDto.setQuantity(cartItem.getQuantity());
        cartItemDto.setId(cartItem.getId());
        cartItemDto.setUserId(cartItem.getUserId());
        return cartItemDto;
    }

    public static CartItem mapToCartItem(CartItemDto cartItemDto, CartItem cartItem){
        cartItem.setProductId(cartItemDto.getProductId());
        cartItem.setQuantity(cartItemDto.getQuantity());
        cartItemDto.setUserId(cartItem.getUserId());
        return  cartItem;
    }

    public static CartItem mapToCartItem(BaseCartItemDto cartItemDto, CartItem cartItem){
        cartItem.setProductId(cartItemDto.getProductId());
        cartItem.setQuantity(cartItemDto.getQuantity());
        cartItem.setUserId(cartItemDto.getUserId());
        return  cartItem;
    }

}
