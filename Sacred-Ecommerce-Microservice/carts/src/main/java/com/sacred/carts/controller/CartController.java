package com.sacred.carts.controller;

import com.sacred.carts.constants.CartsConstants;
import com.sacred.carts.dto.CartItemDto;
import com.sacred.carts.dto.CartsDto;
import com.sacred.carts.dto.ConfigurationDto;
import com.sacred.carts.dto.exceptions.ErrorResponseDto;
import com.sacred.carts.dto.exceptions.ResponseDto;
import com.sacred.carts.dto.extensions.BaseCartItemDto;
import com.sacred.carts.entity.Cart;
import com.sacred.carts.entity.CartItem;
import com.sacred.carts.services.ICartService;
import com.sacred.carts.services.impl.CartService;
import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/")
@OpenAPIDefinition(
        info = @Info(
                title = "Products Microservice Rest Documentation",
                description = "Documentation of Sacred-Ecommerce-Microservices Carts Microservice REST API",
                version = "v1",
                license = @License(
                        url = "will replace with linkedin"
                )
        ),
        externalDocs = @ExternalDocumentation(
                description = "Sacred-Ecommerce Carts microservice REST API Documentation"
        )
)
public class CartController {

    private final ICartService cartService;
    private final ConfigurationDto configurationDto;

    public CartController(CartService cartService, ConfigurationDto configurationDto) {
        this.cartService = cartService;
        this.configurationDto = configurationDto;
    }

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
    @PostMapping("/createCart")
    public ResponseEntity<ResponseDto> addToCart(@Valid @RequestBody BaseCartItemDto baseCartItemDto){
        cartService.addCartItem(baseCartItemDto);
        return ResponseEntity.status(201).body(new ResponseDto(
                HttpStatus.CREATED,
                CartsConstants.MESSAGE_201
        ));
    }

    @Operation( summary = "Fetch Cart REST API",description = "REST API to fetch Cart details inside Sacred-Ecommerce")
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
    @GetMapping("/fetchCart")
    public ResponseEntity<CartsDto> fetchCart(@RequestParam String userId){
        CartsDto cartByUserId = cartService.getCartByUserId(Long.valueOf(userId));
        return ResponseEntity.status(201).body(cartByUserId);
    }

    @Operation( summary = "Fetch CartItem REST API",description = "REST API to fetch CartItem details inside Sacred-Ecommerce")
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
    @GetMapping("/fetchCartItem")
    public ResponseEntity<CartItemDto> fetchCartItem(@RequestParam Long cartItemId){
        CartItemDto cartItemDto = cartService.getCartItemById(cartItemId);
        return ResponseEntity.status(201).body(cartItemDto);
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
