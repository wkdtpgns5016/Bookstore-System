package com.example.BookstoreSystem.controller;

import com.example.BookstoreSystem.model.CartRequest;
import com.example.BookstoreSystem.model.CartResponse;
import com.example.BookstoreSystem.service.CartService;
import org.springframework.web.bind.annotation.*;

@RestController
public class CartController {
    private final CartService cartService;
    public CartController(CartService cartService) { this.cartService = cartService; }

    @GetMapping("/carts/{cartId}")
    public CartResponse readCart(@PathVariable String cartId) { return cartService.readCart(cartId); }

    @PostMapping("/carts")
    public int creatCart(@RequestBody CartRequest cartRequest) {
        return cartService.creatAddCart(cartRequest);
    }

    @DeleteMapping("/carts/{cartId}")
    public int deleteCart(@PathVariable String cartId) { return cartService.deleteCart(cartId); }
}
