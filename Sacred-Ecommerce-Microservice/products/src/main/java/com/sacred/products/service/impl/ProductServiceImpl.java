package com.sacred.products.service.impl;

import com.sacred.products.constants.InventoryStatus;
import com.sacred.products.dto.InventoryDto;
import com.sacred.products.dto.ProductDto;
import com.sacred.products.dto.Pagination;
import com.sacred.products.dto.responses.PageResponse;
import com.sacred.products.dto.searches.ProductSearches;
import com.sacred.products.entity.Category;
import com.sacred.products.entity.Inventory;
import com.sacred.products.entity.Product;
import com.sacred.products.exception.RequestFormulationException;
import com.sacred.products.exception.ResourceNotFoundException;
import com.sacred.products.mapper.Impl.InventoryMapperImpl;
import com.sacred.products.mapper.Impl.ProductMapperImpl;
import com.sacred.products.repository.ICategoryRepository;
import com.sacred.products.repository.IInventoryRepository;
import com.sacred.products.repository.IProductRepository;
import com.sacred.products.repository.pageable.ProductPageable;
import com.sacred.products.repository.spec.ProductSpecification;
import com.sacred.products.service.IProductService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ProductServiceImpl implements IProductService {

    private final IProductRepository iproductRepository;
    private final ICategoryRepository icategoryRepository;
    private final IInventoryRepository inventoryRepository;

    /**
     * @param productDto - type ProductDto
     * used to create product
     */
    @Override
    public void addProduct(ProductDto productDto) {
        //Product quantity to save or update with
        int productQuantity = productDto.getQuantity();
        Product product = ProductMapperImpl.mapToProduct(productDto, new Product());

        if(productDto.getCategory() == null){
            throw new RequestFormulationException("Category","Product", null);
        }

        Category category = icategoryRepository
                .findById(productDto.getCategory())
                .orElseThrow(() -> new ResourceNotFoundException("Category", "Name", productDto.getCategory().toString()));

        product.setCategory(category);
        Product savedProduct = iproductRepository.save(product);

        Optional<Inventory> optionalInventorySaved = inventoryRepository.findByProduct(savedProduct);
        if(optionalInventorySaved.isPresent()){
            productQuantity += optionalInventorySaved.get().getQuantity();
        }

        InventoryDto inventoryDto = new InventoryDto();
        inventoryDto.setProduct(savedProduct);
        inventoryDto.setQuantity(productQuantity);
        inventoryDto.setInventoryStatus(setInventoryStatus(productQuantity));

        Inventory inventory = InventoryMapperImpl.mapToInventory(inventoryDto, new Inventory());
        inventoryRepository.save(inventory);

    }

    /**
     * @param productId - type String
     *                  used to fetch product by id
     * @return ProductDto
     */
    @Override
    public ProductDto fetchProduct(Long productId) {
        Product product = getProductById(productId);
        return ProductMapperImpl.mapToProductDto(product, new ProductDto());
    }


    /**
     * @param productSearches - type ProductSearches
     *                        Fetch products and paginate
     * @return boolean
     */
    @Override
    public PageResponse<ProductDto> filterProducts(ProductSearches productSearches) {
        //search and filter
        Specification<Product> productSpec =
                ProductSpecification.containsName(productSearches.getName())
                .or(ProductSpecification.containDescription(productSearches.getDescription()))
                .and(ProductSpecification.hasMinPrice(productSearches.getMinPrice())
                        .and(ProductSpecification.hasMaxPrice(productSearches.getMaxPrice()))
                );
        //pagination
        Pageable productPageable = ProductPageable.productFilterPaginationSorting(productSearches);
        Page<Product> filteredPaginationProducts = iproductRepository.findAll(productSpec, productPageable);

        Pagination pagination = new Pagination();
        pagination.setCurrentPage(filteredPaginationProducts.getNumber());
        pagination.setPageSize(filteredPaginationProducts.getSize());
        pagination.setTotalItems(filteredPaginationProducts.getTotalElements());
        pagination.setTotalPages(filteredPaginationProducts.getTotalPages());

        List<ProductDto> filteredProductDto_s = filteredPaginationProducts.stream().map(_product -> ProductMapperImpl.mapToProductDto(_product, new ProductDto())).toList();

        return new PageResponse<>(filteredProductDto_s, pagination);
    }

    /**
     * @param productDto - type String
     *                   used to update product by id
     * @return boolean
     */
    @Override
    public boolean updateProduct(ProductDto productDto) {
        boolean isUpdated = false;
        Product productById = getProductById(productDto.getId());
        Product productUpdate = ProductMapperImpl.mapToProduct(productDto, productById);
        iproductRepository.save(productUpdate);
        isUpdated = true;
        return isUpdated;
    }

    /**
     * @param productId - type String
     *                  used to delete product by id
     * @return boolean
     */
    @Override
    public boolean deleteProduct(Long productId) {
        boolean isDeleted = false;
        Product product = getProductById(productId);
        iproductRepository.delete(product);
        isDeleted = true;
        return isDeleted;
    }

    private InventoryStatus setInventoryStatus(int quantity){
        if(quantity >= 0 && quantity <= 50){
            return InventoryStatus.OUT_OF_STOCK;
        }else if(quantity >= 50 && quantity <= 100){
            return  InventoryStatus.NEEDS_REPLENISHMENT;
        }else {
            return InventoryStatus.IN_STOCK;
        }
    }

    private Product getProductById(Long productId){
        return iproductRepository.findById(productId)
                .orElseThrow(()-> new ResourceNotFoundException("Product", "id", productId.toString()));
    }
}
