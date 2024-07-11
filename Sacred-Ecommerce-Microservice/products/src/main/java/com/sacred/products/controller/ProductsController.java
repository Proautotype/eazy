package com.sacred.products.controller;

import com.sacred.products.constants.ProductConstants;
import com.sacred.products.dto.ConfigurationDto;
import com.sacred.products.dto.responses.ErrorResponseDto;
import com.sacred.products.dto.ProductDto;
import com.sacred.products.dto.responses.PageResponse;
import com.sacred.products.dto.responses.ResponseDto;
import com.sacred.products.dto.searches.ProductSearches;
import com.sacred.products.service.IProductService;
import com.sacred.products.service.impl.ProductServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Pattern;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.InvalidPropertiesFormatException;
import java.util.List;

import static com.sacred.products.entity.Category_.products;



@Tag(
        name = "PRODUCTS REST controller",
        description = "PRODUCTS REST APIs to CREATE, UPDATE, FETCH and DELETE Products details in PRODUCT_MS"
)
@Validated
@RestController
@RequestMapping(name = "api/v1")
public class ProductsController {

    private final IProductService productService;
    private final ConfigurationDto configurationDto;

    public ProductsController(ProductServiceImpl productService, ConfigurationDto configurationDto) {
        this.productService = productService;
        this.configurationDto = configurationDto;
    }

    /*******************************************/

    @Operation( summary = "Create Product REST API",description = "REST API to create new Product inside Products MS")
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "HTTP Status CREATED: operation successful"),
            @ApiResponse(responseCode = "409", description = "HTTP Status CONFLICT: resource already exist"),
            @ApiResponse(
                    responseCode = "500",
                    description = "HTTP Status SERVER_ERROR: internal server error",
                    content = @Content(
                            schema = @Schema(implementation = ErrorResponseDto.class)
                    )
            ),
    })
    @PostMapping("/createProduct")
    public ResponseEntity<ResponseDto> createProduct(@Valid @RequestBody ProductDto productDto){
        System.out.println(productDto);

        productService.addProduct(productDto);
        return ResponseEntity.status(201).body(new ResponseDto(
                HttpStatus.CREATED,
                ProductConstants.MESSAGE_201
        ));
    }

    @Operation( summary = "Fetch Product REST API",description = "REST API to fetch Product details inside Sacred-Ecommerce")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "HTTP Status OK: operation successful"),
            @ApiResponse(responseCode = "400", description = "HTTP Status CLIENT_ERROR: "),
            @ApiResponse(
                    responseCode = "500",
                    description = "HTTP Status SERVER_ERROR: internal server error",
                    content = @Content(
                            schema = @Schema(implementation = ErrorResponseDto.class)
                    )
            ),
    })
    @GetMapping("/fetchProduct")
    public ResponseEntity<ProductDto> fetchProduct(@RequestParam Long productId){
        ProductDto productDto = productService.fetchProduct(productId);
        return ResponseEntity.status(HttpStatus.OK).body(productDto);
    }

    @Operation( summary = "Fetch Product Filter REST API",description = "REST API to fetch Product details with filter inside Sacred-Ecommerce")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "HTTP Status OK: operation successful"),
            @ApiResponse(responseCode = "400", description = "HTTP Status CLIENT_ERROR: "),
            @ApiResponse(
                    responseCode = "500",
                    description = "HTTP Status SERVER_ERROR: internal server error",
                    content = @Content(
                            schema = @Schema(implementation = ErrorResponseDto.class)
                    )
            ),
    })
    @PostMapping("/filterProduct")
    public ResponseEntity<PageResponse<ProductDto>> filterProduct(@RequestBody ProductSearches productSearches){
        System.out.println(productSearches.toString());
        PageResponse<ProductDto> productDtoPageResponse = productService.filterProducts(productSearches);
        return ResponseEntity.status(HttpStatus.OK).body(productDtoPageResponse);
    }

    @Operation( summary = "Fetch Product Filter REST API",
            description = "REST API to fetch Product details with filter inside Sacred-Ecommerce")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "HTTP Status OK: operation successful"),
            @ApiResponse(responseCode = "400", description = "HTTP Status CLIENT_ERROR: "),
            @ApiResponse(
                    responseCode = "500",
                    description = "HTTP Status SERVER_ERROR: internal server error",
                    content = @Content(
                            schema = @Schema(implementation = ErrorResponseDto.class)
                    )
            ),
    })
    @GetMapping("/filterProduct")
    public ResponseEntity<PageResponse<ProductDto>> filterProductGet(
            @RequestParam(required = false)  String name,
            @RequestParam(required = false)  String description,
            @RequestParam double minPrice,
            @RequestParam double maxPrice,
            @RequestParam int pageNumber,
            @RequestParam int pageSize
    ) throws InvalidPropertiesFormatException {

        ProductSearches productSearches = new ProductSearches();
        productSearches.setName(name);
        productSearches.setDescription(description);
        productSearches.setMinPrice(minPrice);
        productSearches.setMaxPrice(maxPrice);
        productSearches.setPageNumber(pageNumber);
        productSearches.setPageSize(pageSize);

        PageResponse<ProductDto> productDtoPageResponse = productService.filterProducts(productSearches);
        return ResponseEntity.status(HttpStatus.OK).body(productDtoPageResponse);
    }

    @Operation( summary = "Update Product REST API",description = "REST API to Update Product details inside Sacred-Ecommerce")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "HTTP Status OK: operation successful"),
            @ApiResponse(responseCode = "417", description = "HTTP Status CLIENT_ERROR: update operation not successful"),
            @ApiResponse(
                    responseCode = "500",
                    description = "HTTP Status SERVER_ERROR: internal server error",
                    content = @Content(
                            schema = @Schema(implementation = ErrorResponseDto.class)
                    )
            ),
    })
    @PatchMapping("/updateProduct")
    public ResponseEntity<ResponseDto> updateProduct(@Valid @RequestBody ProductDto productDto){
        boolean updatedProduct = productService.updateProduct(productDto);
        if(updatedProduct){
            return ResponseEntity
                    .status(ProductConstants.STATUS_203)
                    .body(new ResponseDto(HttpStatus.ACCEPTED, ProductConstants.MESSAGE_203_UPDATE));
        }else {
            return ResponseEntity.status(ProductConstants.STATUS_403)
                    .body(new ResponseDto(HttpStatus.ACCEPTED, ProductConstants.MESSAGE_403_DELETE));
        }
    }

    @Operation( summary = "Delete Product REST API",description = "REST API to Delete Product inside Sacred-Ecommerce")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "HTTP Status OK: operation successful"),
            @ApiResponse(responseCode = "417", description = "HTTP Status CLIENT_ERROR: delete operation not successful"),
            @ApiResponse(
                    responseCode = "500",
                    description = "HTTP Status SERVER_ERROR: internal server error",
                    content = @Content(
                            schema = @Schema(implementation = ErrorResponseDto.class)
                    )
            ),
    })
    @DeleteMapping("/deleteProduct")
    public ResponseEntity<ResponseDto> deleteProduct(Long productId){
        boolean deleteProduct = productService.deleteProduct(productId);
        if(deleteProduct){
            return ResponseEntity
                    .status(ProductConstants.STATUS_203)
                    .body(new ResponseDto(HttpStatus.ACCEPTED, ProductConstants.MESSAGE_203_DELETE));
        }else {
            return ResponseEntity.status(ProductConstants.STATUS_403)
                    .body(new ResponseDto(HttpStatus.ACCEPTED, ProductConstants.MESSAGE_403_DELETE));
        }
    }

    @Operation(
            summary = "Get contact information",
            description = "Get contact information of the developer that deployed  account microservice"
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "HTTP Status OK"
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "HTTP Status Internal Server Error",
                    content = @Content(
                            schema = @Schema(implementation = ErrorResponseDto.class)
                    )
            )
    }
    )
    @GetMapping("/contact-info")
    public ResponseEntity<ConfigurationDto> getContactInfo(){
        return ResponseEntity.status(HttpStatus.OK).body(configurationDto);
    }

}
