package com.sacred.products.dto.responses;

import com.sacred.products.dto.Pagination;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PageResponse<T> {
    List<T> data;
    Pagination pagination;
}
