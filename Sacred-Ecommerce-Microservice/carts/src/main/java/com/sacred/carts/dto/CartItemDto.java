package com.sacred.carts.dto;

import com.sacred.carts.dto.extensions.BaseCartItemDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CartItemDto extends BaseCartItemDto {
    private Long id;
}
