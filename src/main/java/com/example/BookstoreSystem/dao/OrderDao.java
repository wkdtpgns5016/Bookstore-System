package com.example.BookstoreSystem.dao;

import com.example.BookstoreSystem.model.OrderDto;
import com.example.BookstoreSystem.model.OrderSelectionDto;
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
        return sqlSession.selectList("com.example.BookstoreSystem.dao.OrderDao.selectOrderList");
    }

    public List<OrderDto> selectOrderListByUserId(String userId) {
        HashMap<String,Object> param = new HashMap<>();
        param.put("userId", userId);
        return sqlSession.selectList("com.example.BookstoreSystem.dao.OrderDao.selectOrderListByUserId",param);
    }

    public OrderDto selectOrderInfo(String number) {
        HashMap<String,Object> param = new HashMap<>();
        param.put("number", number);
        return sqlSession.selectOne("com.example.BookstoreSystem.dao.OrderDao.selectOrderInfo",param);
    }

    public int insertOrderInfo(OrderDto order) {
        HashMap<String,Object> param = new HashMap<>();
        param.put("order", order);
        return sqlSession.insert("com.example.BookstoreSystem.dao.OrderDao.insertOrderInfo",param);
    }

    public int updateOrderInfo(OrderDto order) {
        HashMap<String,Object> param = new HashMap<>();
        param.put("order", order);
        return sqlSession.update("com.example.BookstoreSystem.dao.OrderDao.updateOrderInfo",param);
    }

    public int deleteOrderInfo(String number) {
        HashMap<String,Object> param = new HashMap<>();
        param.put("number", number);
        return sqlSession.delete("com.example.BookstoreSystem.dao.OrderDao.deleteOrderInfo",param);
    }

    public List<OrderSelectionDto> selectOrderSelectionByOrderNumber(String orderNumber) {
        HashMap<String,Object> param = new HashMap<>();
        param.put("orderNumber", orderNumber);
        return sqlSession.selectList("com.example.BookstoreSystem.dao.OrderDao.selectOrderSelectionByOrderNumber",param);
    }

    public int insertOrderSelectionInfo(OrderSelectionDto orderSelection) {
        HashMap<String,Object> param = new HashMap<>();
        param.put("orderSelection", orderSelection);
        return sqlSession.insert("com.example.BookstoreSystem.dao.OrderDao.insertOrderSelectionInfo",param);
    }

    public int deleteOrderSelectionByOrderNumber(String orderNumber) {
        HashMap<String,Object> param = new HashMap<>();
        param.put("orderNumber", orderNumber);
        return sqlSession.delete("com.example.BookstoreSystem.dao.OrderDao.deleteOrderSelectionByOrderNumber",param);
    }
}
