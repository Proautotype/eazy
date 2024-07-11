package com.sacred.products.dto.searches;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
public class PageQueries {
    private int pageNumber;
    private int pageSize;
}
