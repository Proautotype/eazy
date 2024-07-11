package com.sacred.carts.services;

import com.sacred.carts.dto.CartItemDto;
import com.sacred.carts.dto.CartsDto;
import com.sacred.carts.dto.extensions.BaseCartItemDto;
import com.sacred.carts.entity.Cart;

public interface ICartService {
    void addCartItem(BaseCartItemDto cartItemDto);
    Cart createCart(BaseCartItemDto baseCartItemDto);
    CartsDto getCartByUserId(Long userId);

    CartsDto getCartByProductId(Long productId);

    CartItemDto getCartItemById(Long userId);
}
