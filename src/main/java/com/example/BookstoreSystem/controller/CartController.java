package com.example.BookstoreSystem.controller;

import com.example.BookstoreSystem.model.CartDto;
import com.example.BookstoreSystem.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CartController {
    private final CartService cartService;
    public CartController(CartService cartService) { this.cartService = cartService; }

    @GetMapping("/carts")
    public List<CartDto> selectCartListByUserId(String userId) { return cartService.selectCartListByUserId(userId); }

    @GetMapping("/carts/{id}")
    public CartDto selectCartInfo(int id) { return cartService.selectCartInfo(id); }
}
