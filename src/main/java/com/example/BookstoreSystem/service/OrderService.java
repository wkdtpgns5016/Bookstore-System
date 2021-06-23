package com.example.BookstoreSystem.service;

import com.example.BookstoreSystem.model.OrderDto;
import com.example.BookstoreSystem.model.OrderRequest;
import com.example.BookstoreSystem.model.OrderSelectionDto;

import java.util.List;

public interface OrderService {
    public List<OrderDto> selectOrderList();
    public OrderDto selectOrderInfo(String number);
    public int insertOrderInfo(OrderDto order);
    public int updateOrderInfo(OrderDto order);
    public int deleteOrderInfo(String number);
    public List<OrderSelectionDto> selectOrderSelectionByOrderNumber(String orderNumber);
    public int insertOrderSelectionInfo(OrderSelectionDto orderSelection);
    public int deleteOrderSelectionByOrderNumber(String orderNumber);
    public int createOrder(OrderRequest orderRequest);
}
