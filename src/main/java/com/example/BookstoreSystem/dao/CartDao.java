package com.example.BookstoreSystem.dao;

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
}
