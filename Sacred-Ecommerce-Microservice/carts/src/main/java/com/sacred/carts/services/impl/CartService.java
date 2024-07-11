package com.sacred.carts.services.impl;

import com.sacred.carts.dto.CartItemDto;
import com.sacred.carts.dto.CartsDto;
import com.sacred.carts.dto.extensions.BaseCartItemDto;
import com.sacred.carts.dto.searchs.Searches;
import com.sacred.carts.entity.Cart;
import com.sacred.carts.entity.CartItem;
import com.sacred.carts.exceptions.ResourceNotFoundException;
import com.sacred.carts.mapper.impl.CartItemMapper;
import com.sacred.carts.mapper.impl.CartMapperImpl;
import com.sacred.carts.repository.CartItemRepository;
import com.sacred.carts.repository.CartRepository;
import com.sacred.carts.repository.spec.CartSpecification;
import com.sacred.carts.services.ICartService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CartService implements ICartService {

    private final CartRepository cartRepository;
    private final CartItemRepository cartItemRepository;

    @Override
    public void addCartItem(BaseCartItemDto cartItemDto){
        Optional<Cart> optionalCart = cartRepository.findByUserId(cartItemDto.getUserId());
        Cart spottedCart = optionalCart.orElseGet(() -> createCart(cartItemDto));
        //is product in cart
        int quantity = 0;
        Optional<CartItem> optionalCartItem = cartItemRepository.findByCartAndProductId(spottedCart, cartItemDto.getProductId());

        if(optionalCartItem.isPresent()){
            CartItem availableCartItem = optionalCartItem.get();
            quantity = availableCartItem.getQuantity();
            quantity += cartItemDto.getQuantity();
            availableCartItem.setQuantity(quantity);
            cartItemRepository.save(availableCartItem);
        }else{
            CartItem cartItem = CartItemMapper.mapToCartItem(cartItemDto, new CartItem());
            cartItem.setCart(spottedCart);
            cartItemRepository.save(cartItem);
        }


    }

    @Override
    public Cart createCart(BaseCartItemDto baseCartItemDto) {
        Cart newCart = CartMapperImpl.mapToCart(baseCartItemDto, new Cart());
        return cartRepository.save(newCart);
    }

    @Override
    public CartsDto getCartByUserId(Long userId) {
        Cart cart = cartRepository.findByUserId(userId).orElseThrow(() -> new ResourceNotFoundException("Cart", "userId", userId.toString()));
        return CartMapperImpl.mapToCartDto(cart, new CartsDto());
    }

    @Override
    public CartsDto getCartByProductId(Long productId){
        cartRepository.findAll(CartSpecification.hasProduct(productId));
        return new CartsDto(productId);
    }

    public CartsDto getCartByUserAndProduct(Searches.SearchByUserAndProduct searchByUserAndProduct){
        List<Cart> carts = cartRepository.findAll(
                CartSpecification.ofUser(searchByUserAndProduct.getUserId())
                        .and(CartSpecification.hasProduct(searchByUserAndProduct.getProductId())));
        return new CartsDto(searchByUserAndProduct.getProductId());
    }

    @Override
    public CartItemDto getCartItemById(Long cartItemId) {
        CartItem cartItem = cartItemRepository
                .findById(cartItemId)
                .orElseThrow(() -> new ResourceNotFoundException("CartItem", "idd", cartItemId.toString()));

        CartItemDto cartItemDto = CartItemMapper.mapToCartItemDto(cartItem, new CartItemDto());

        System.out.println(cartItemId);

        return cartItemDto;
    }


}
