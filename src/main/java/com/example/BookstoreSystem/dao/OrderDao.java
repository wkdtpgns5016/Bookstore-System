package com.example.BookstoreSystem.dao;

import com.example.BookstoreSystem.model.OrderDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

@Mapper
@Repository
public class OrderDao {
    private final SqlSession sqlSession;
    public OrderDao(SqlSession sqlSession) { this.sqlSession = sqlSession; }

    public List<OrderDto> selectOrderList() {
        return sqlSession.selectList("com.example.BookstoreSystem.dao.orderDao.selectOrderList");
    }

    public OrderDto selectOrderInfo(int number) {
        HashMap<String,Object> param = new HashMap<>();
        param.put("number", number);
        return sqlSession.selectOne("com.example.BookstoreSystem.dao.orderDao.selectOrderInfo",param);
    }
}
