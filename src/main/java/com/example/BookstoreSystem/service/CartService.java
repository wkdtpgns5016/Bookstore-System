package com.example.BookstoreSystem.service;

import com.example.BookstoreSystem.model.AddCartDto;
import com.example.BookstoreSystem.model.CartDto;

import java.util.List;

public interface CartService {
    public List<CartDto> selectCartListByUserId(String userId);
    public CartDto selectCartInfo(int id);
    public int insertCartInfo(CartDto cart);
    public int updateCartInfo(CartDto cart);
    public int deleteCartByUserId(String userId);
    public int deleteCartInfo(int id);
    public List<AddCartDto> selectAddCartByCardId(int cardId);
    public int insertAddCartInfo(AddCartDto addCart);
}
