package com.example.BookstoreSystem.service;

import com.example.BookstoreSystem.model.OrderDto;

import java.util.List;

public interface OrderService {
    public List<OrderDto> selectOrderList();
    public OrderDto selectOrderInfo(int number);
    public int insertOrderInfo(OrderDto order);
    public int updateOrderInfo(OrderDto order);
    public int deleteOrderInfo(int number);
}
