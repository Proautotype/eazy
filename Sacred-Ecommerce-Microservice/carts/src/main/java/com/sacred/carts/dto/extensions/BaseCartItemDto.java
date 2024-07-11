package com.sacred.carts.dto.extensions;

import lombok.Data;

@Data
public class BaseCartItemDto {
    private Long userId;
    private int quantity;
    private Long productId;
}
