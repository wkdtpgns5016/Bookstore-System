package com.example.BookstoreSystem.service;

import com.example.BookstoreSystem.dao.OrderDao;
import com.example.BookstoreSystem.model.BookDto;
import com.example.BookstoreSystem.model.OrderDto;
import com.example.BookstoreSystem.model.OrderRequest;
import com.example.BookstoreSystem.model.OrderSelectionDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service("OrderService")
public class OrderServiceImpl implements OrderService {
    private final BookService bookService;
    private final OrderDao orderDao;
    public OrderServiceImpl(OrderDao orderDao, BookService bookService) {
        this.orderDao = orderDao;
        this.bookService = bookService;
    }

    @Override
    public List<OrderDto> selectOrderList() { return orderDao.selectOrderList(); }

    @Override
    public OrderDto selectOrderInfo(String number) { return orderDao.selectOrderInfo(number); }

    @Override
    public int insertOrderInfo(OrderDto order) { return orderDao.insertOrderInfo(order); }

    @Override
    public int updateOrderInfo(OrderDto order) { return orderDao.updateOrderInfo(order); }

    @Override
    public int deleteOrderInfo(String number) { return orderDao.deleteOrderInfo(number); }

    @Override
    public List<OrderSelectionDto> selectOrderSelectionByOrderNumber(String orderNumber) {
        return orderDao.selectOrderSelectionByOrderNumber(orderNumber);
    }

    @Override
    public int insertOrderSelectionInfo(OrderSelectionDto orderSelection) {
        return orderDao.insertOrderSelectionInfo(orderSelection);
    }

    @Override
    public int deleteOrderSelectionByOrderNumber(String orderNumber) {
        return orderDao.deleteOrderSelectionByOrderNumber(orderNumber);
    }

    @Override
    public int createOrder(OrderRequest orderRequest) {
        SimpleDateFormat format = new SimpleDateFormat ( "yyyyMMddHHmmss");
        Date time = new Date();
        String date = format.format(time);
        String id = date + orderRequest.getUserId();

        OrderDto orderDto = new OrderDto();
        orderDto.setNumber(id);
        orderDto.setCardNumber(orderRequest.getCardNumber());
        orderDto.setCardExpirationDate(orderRequest.getCardExpirationDate());
        orderDto.setCardType(orderRequest.getCardType());
        orderDto.setUserId(orderRequest.getUserId());
        orderDto.setAddressZoneCode(orderRequest.getAddressZoneCode());
        orderDto.setDefaultAddress(orderRequest.getDefaultAddress());
        orderDto.setDetailAddress(orderRequest.getDetailAddress());
        orderDto.setTotalAmount(clacTotalAmount(orderRequest.getOrders()));
        orderDto.setState("신청");

        int result = insertOrderInfo(orderDto);

        for(OrderSelectionDto order : orderRequest.getOrders()) {
            order.setOrderNumber(id);
            insertOrderSelectionInfo(order);
        }

        return result;
    }

    private int clacTotalAmount(List<OrderSelectionDto> orders) {
        int amount = 0;
        for(OrderSelectionDto order : orders) {
            BookDto book = bookService.selectBookInfo(order.getBookId());
            int price = book.getPrice() * order.getQuantity();
            amount += price;
        }
        return amount;
    }
}
