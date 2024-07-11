package com.sacred.carts.dto.searchs;

import lombok.AllArgsConstructor;
import lombok.Data;

public class Searches {

    @Data
    @AllArgsConstructor
    public static class SearchByUserAndProduct{
        private Long userId, productId;
    }
}
