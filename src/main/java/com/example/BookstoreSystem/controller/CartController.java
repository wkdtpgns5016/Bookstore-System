package com.example.BookstoreSystem.controller;

import com.example.BookstoreSystem.model.AddCartDto;
import com.example.BookstoreSystem.model.CartDto;
import com.example.BookstoreSystem.model.CartRequest;
import com.example.BookstoreSystem.model.CartResponse;
import com.example.BookstoreSystem.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
}
