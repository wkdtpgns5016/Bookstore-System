package com.example.BookstoreSystem.controller;

import com.example.BookstoreSystem.model.AddCartDto;
import com.example.BookstoreSystem.model.CartDto;
import com.example.BookstoreSystem.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CartController {
    private final CartService cartService;
    public CartController(CartService cartService) { this.cartService = cartService; }

    @GetMapping("/carts")
    public List<CartDto> selectCartListByUserId(@PathVariable String userId) { return cartService.selectCartListByUserId(userId); }

    @GetMapping("/carts/{id}")
    public CartDto selectCartInfo(@PathVariable int id) { return cartService.selectCartInfo(id); }
  
    @PostMapping("/carts")
    public int insertCartInfo(@RequestBody CartDto cart) { return cartService.insertCartInfo(cart); }
  
    @PutMapping("/carts")
    public int updateCartInfo(@RequestBody CartDto cart) { return cartService.updateCartInfo(cart); }
  
    @DeleteMapping("/carts/{userId}")
    public int deleteCartByUserId(@PathVariable String userId) { return cartService.deleteCartByUserId(userId); }

    @DeleteMapping("/carts/{id}")
    public int deleteCartInfo(@PathVariable int id) { return cartService.deleteCartInfo(id); }

    @GetMapping("/add-carts/{cardId}")
    public List<AddCartDto> selectAddCartByCardId(@PathVariable int cardId) {
        return cartService.selectAddCartByCardId(cardId);
    }

    @PutMapping("/add-carts")
    public int insertAddCartInfo(@RequestBody AddCartDto addCart) {
        return cartService.insertAddCartInfo(addCart);
    }

    @DeleteMapping("/add-carts")
    public int deleteAddCartByCardId(@PathVariable int cartId) { return cartService.deleteAddCartByCardId(cartId); }
}
