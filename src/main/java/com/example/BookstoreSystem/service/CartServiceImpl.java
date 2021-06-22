package com.example.BookstoreSystem.service;

import com.example.BookstoreSystem.dao.CartDao;
import com.example.BookstoreSystem.model.CartDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("CartService")
public class CartServiceImpl implements CartService {
    private final CartDao cartDao;
    public CartServiceImpl(CartDao cartDao) { this.cartDao = cartDao; }

    @Override
    public List<CartDto> selectCartListByUserId(String userId) { return cartDao.selectCartListByUserId(userId); }

    @Override
    public CartDto selectCartInfo(int id) { return cartDao.selectCartInfo(id); }

    @Override
    public int updateCartInfo(CartDto cart) { return cartDao.updateCartInfo(cart); }
}
