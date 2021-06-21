package com.example.BookstoreSystem.service;

import com.example.BookstoreSystem.dao.OrderDao;
import com.example.BookstoreSystem.model.OrderDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("OrderService")
public class OrderServiceImpl implements OrderService {
    private final OrderDao orderDao;
    public OrderServiceImpl(OrderDao orderDao) { this.orderDao = orderDao; }

    @Override
    public List<OrderDto> selectOrderList() { return orderDao.selectOrderList(); }

    @Override
    public OrderDto selectOrderInfo(int number) { return orderDao.selectOrderInfo(number); }
}
