package com.sacred.products.controller;

import com.sacred.products.constants.ProductConstants;
import com.sacred.products.dto.extensions.BaseCategoryDto;
import com.sacred.products.dto.responses.ErrorResponseDto;
import com.sacred.products.dto.responses.ResponseDto;
import com.sacred.products.service.ICategoryService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1")
@Tag(
        name = "CATEGORY REST Controller",
        description = "REST api to CREATE,READ, UPDATE, and Delete CATEGORY details in PRODUCT_MS")
public class CategoryController {

    private final ICategoryService iCategoryService;

    /**************************/

    public CategoryController(ICategoryService iCategoryService) {
        this.iCategoryService = iCategoryService;
    }

    @Operation( summary = "Create Category REST API",description = "REST API to create new Category inside Products MS")
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
    @PostMapping("/createCategory")
    public ResponseEntity<ResponseDto> createCategory(@Valid @RequestBody BaseCategoryDto categoryDto){
        iCategoryService.addCategory(categoryDto);
        return ResponseEntity.status(201).body(new ResponseDto(
                HttpStatus.CREATED,
                ProductConstants.MESSAGE_201
        ));
    }

}
