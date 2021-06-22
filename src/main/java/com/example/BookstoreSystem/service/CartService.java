package com.example.BookstoreSystem.service;

import com.example.BookstoreSystem.model.CartDto;

import java.util.List;

public interface CartService {
    public List<CartDto> selectCartListByUserId(String userId);
    public CartDto selectCartInfo(int id);
    public int insertCartInfo(CartDto cart);
}
