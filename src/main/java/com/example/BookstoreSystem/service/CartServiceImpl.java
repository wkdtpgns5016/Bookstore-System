package com.example.BookstoreSystem.service;

import com.example.BookstoreSystem.dao.CartDao;
import com.example.BookstoreSystem.model.AddCartDto;
import com.example.BookstoreSystem.model.CartDto;
import com.example.BookstoreSystem.model.CartRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
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
    public int insertCartInfo(CartDto cart) { return cartDao.insertCartInfo(cart); }
  
    @Override
    public int updateCartInfo(CartDto cart) { return cartDao.updateCartInfo(cart); }
  
    @Override
    public int deleteCartByUserId(String userId) { return cartDao.deleteCartByUserId(userId); }

    @Override
    public int deleteCartInfo(int id) { return cartDao.deleteCartInfo(id); }

    @Override
    public List<AddCartDto> selectAddCartByCardId(int cardId) {
        return cartDao.selectAddCartByCardId(cardId);
    }

    @Override
    public int insertAddCartInfo(AddCartDto addCart) {
        return cartDao.insertAddCartInfo(addCart);
    }

    @Override
    public int deleteAddCartByCardId(int cartId) {
        return cartDao.deleteAddCartByCardId(cartId);
    }

    @Override
    public int creatAddCart(CartRequest cartRequest) {
        SimpleDateFormat format = new SimpleDateFormat ( "yyyyMMddHHmmss");
        Date time = new Date();
        String date = format.format(time);
        String id = date + cartRequest.getUserId();

        CartDto cartDto = new CartDto();
        cartDto.setId(id);
        cartDto.setUserId(cartRequest.getUserId());
        int result = insertCartInfo(cartDto);

        for(AddCartDto cart : cartRequest.getCarts()) {
            cart.setCartId(id);
            insertAddCartInfo(cart);
        }

        return result;
    }
}
