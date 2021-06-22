package com.example.BookstoreSystem.dao;

import com.example.BookstoreSystem.model.AddCartDto;
import com.example.BookstoreSystem.model.CartDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

@Mapper
@Repository
public class CartDao {
    private final SqlSession sqlSession;
    public CartDao(SqlSession sqlSession) { this.sqlSession = sqlSession; }

    public List<CartDto> selectCartListByUserId(String userId) {
        HashMap<String,Object> param = new HashMap<>();
        param.put("userId", userId);
        return sqlSession.selectList("com.example.BookstoreSystem.dao.CartDao.selectCartListByUserId",param);
    }

    public CartDto selectCartInfo(int id) {
        HashMap<String,Object> param = new HashMap<>();
        param.put("id", id);
        return sqlSession.selectOne("com.example.BookstoreSystem.dao.CartDao.selectCartInfo",param);
    }

    public int insertCartInfo(CartDto cart) {
        HashMap<String, Object> param = new HashMap<>();
        param.put("cart", cart);
        return sqlSession.insert("com.example.BookstoreSystem.dao.CartDao.insertCartInfo", param);
    }

    public int updateCartInfo(CartDto cart) {
        HashMap<String, Object> param = new HashMap<>();
        param.put("cart", cart);
        return sqlSession.update("com.example.BookstoreSystem.dao.CartDao.updateCartInfo", param);
    }

    public int deleteCartByUserId(String userId) {
        HashMap<String,Object> param = new HashMap<>();
        param.put("userId", userId);
        return sqlSession.delete("com.example.BookstoreSystem.dao.CartDao.deleteCartByUserId",param);
    }

    public int deleteCartInfo(int id) {
        HashMap<String,Object> param = new HashMap<>();
        param.put("id", id);
        return sqlSession.delete("com.example.BookstoreSystem.dao.CartDao.deleteCartInfo",param);
    }

    public List<AddCartDto> selectAddCartByCardId(int cardId) {
        HashMap<String,Object> param = new HashMap<>();
        param.put("cardId", cardId);
        return sqlSession.selectList("com.example.BookstoreSystem.dao.CartDao.selectAddCartByCardId",param);
    }

    public int insertAddCartInfo(AddCartDto addCart) {
        HashMap<String,Object> param = new HashMap<>();
        param.put("addCart", addCart);
        return sqlSession.insert("com.example.BookstoreSystem.dao.CartDao.insertAddCartInfo",param);
    }
}
