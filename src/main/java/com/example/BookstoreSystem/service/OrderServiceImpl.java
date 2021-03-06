package com.example.BookstoreSystem.service;

import com.example.BookstoreSystem.dao.OrderDao;
import com.example.BookstoreSystem.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
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
    public List<OrderDto> selectOrderListByUserId(String userId) {
        return orderDao.selectOrderListByUserId(userId);
    }

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
        orderDto.setState("??????");

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

    @Override
    public OrderResponse readOrder(String orderNumber) {
        OrderDto orderDto = selectOrderInfo(orderNumber);
        List<OrderSelectionDto> orderSelectionDtos = selectOrderSelectionByOrderNumber(orderNumber);

        OrderResponse.Card card = new OrderResponse.Card();
        card.setCardType(orderDto.getCardType());
        card.setCardExpirationDate(orderDto.getCardExpirationDate());
        card.setCardNumber(orderDto.getCardNumber());

        OrderResponse.Address address = new OrderResponse.Address();
        address.setAddressZoneCode(orderDto.getAddressZoneCode());
        address.setDetailAddress(orderDto.getDetailAddress());
        address.setDefaultAddress(orderDto.getDefaultAddress());

        List<OrderResponse.Order> orders = new ArrayList<>();
        for(OrderSelectionDto orderSelection : orderSelectionDtos) {
            BookDto bookDto = bookService.selectBookInfo(orderSelection.getBookId());

            OrderResponse.Order order = new OrderResponse.Order();
            order.setBook(bookDto);
            order.setQuantity(orderSelection.getQuantity());
            order.setPrice();

            orders.add(order);
        }

        OrderResponse response = new OrderResponse();
        response.setNumber(orderDto.getNumber());
        response.setUserId(orderDto.getUserId());
        response.setDate(orderDto.getDate());
        response.setTotalAmount(orderDto.getTotalAmount());
        response.setState(orderDto.getState());
        response.setCard(card);
        response.setAddress(address);
        response.setOrders(orders);

        return response;
    }

    @Override
    public int deleteOrder(String orderNumber) {
        deleteOrderSelectionByOrderNumber(orderNumber);
        return deleteOrderInfo(orderNumber);
    }
}
