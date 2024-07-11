package com.sacred.products.repository.pageable;

import com.sacred.products.dto.searches.ProductSearches;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

public class ProductPageable {

//    @Value("${pagingSorting.sortBy}")
//    private static String sortBy;

    public static Pageable productFilterPaginationSorting(ProductSearches productSearches){
        return PageRequest.of(
                productSearches.getPageNumber(),
                productSearches.getPageSize(),
                Sort.by("id").ascending()
        );
    }

}
