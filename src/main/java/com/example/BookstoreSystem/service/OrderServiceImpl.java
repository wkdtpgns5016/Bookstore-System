package com.example.BookstoreSystem.service;

import com.example.BookstoreSystem.dao.OrderDao;
import com.example.BookstoreSystem.model.OrderDto;
import com.example.BookstoreSystem.model.OrderSelectionDto;
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

    @Override
    public int insertOrderInfo(OrderDto order) { return orderDao.insertOrderInfo(order); }

    @Override
    public int updateOrderInfo(OrderDto order) { return orderDao.updateOrderInfo(order); }

    @Override
    public int deleteOrderInfo(int number) { return orderDao.deleteOrderInfo(number); }

    @Override
    public List<OrderSelectionDto> selectOrderSelectionByOrderNumber(int orderNumber) {
        return orderDao.selectOrderSelectionByOrderNumber(orderNumber);
    }

    @Override
    public int insertOrderSelectionInfo(OrderSelectionDto orderSelection) {
        return orderDao.insertOrderSelectionInfo(orderSelection);
    }

    @Override
    public int deleteOrderSelectionByOrderNumber(int orderNumber) {
        return orderDao.deleteOrderSelectionByOrderNumber(orderNumber);
    }
}
