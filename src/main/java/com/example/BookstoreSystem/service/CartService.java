package com.example.BookstoreSystem.service;

import com.example.BookstoreSystem.model.AddCartDto;
import com.example.BookstoreSystem.model.CartDto;
import com.example.BookstoreSystem.model.CartRequest;
import com.example.BookstoreSystem.model.CartResponse;

import java.util.List;

public interface CartService {
    public List<CartDto> selectCartListByUserId(String userId);
    public CartDto selectCartInfo(String id);
    public int insertCartInfo(CartDto cart);
    public int updateCartInfo(CartDto cart);
    public int deleteCartByUserId(String userId);
    public int deleteCartInfo(String id);
    public List<AddCartDto> selectAddCartByCardId(String cardId);
    public int insertAddCartInfo(AddCartDto addCart);
    public int deleteAddCartByCardId(String cartId);
    public int creatAddCart(CartRequest cartRequest);
    public CartResponse readCart(String cartId);
}
