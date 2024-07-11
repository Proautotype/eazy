package com.sacred.carts.dto.extensions;

import com.sacred.carts.dto.CartItemDto;
import com.sacred.carts.entity.CartItem;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BaseCartDto {
    private Long userId;
    private List<CartItemDto> cartItems;
    private boolean emptied;
}
