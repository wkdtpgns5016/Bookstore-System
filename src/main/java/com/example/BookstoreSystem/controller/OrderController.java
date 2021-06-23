package com.example.BookstoreSystem.controller;

import com.example.BookstoreSystem.model.OrderDto;
import com.example.BookstoreSystem.model.OrderRequest;
import com.example.BookstoreSystem.model.OrderResponse;
import com.example.BookstoreSystem.model.OrderSelectionDto;
import com.example.BookstoreSystem.service.OrderService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OrderController {
    private final OrderService orderService;
    public OrderController(OrderService orderService) { this.orderService = orderService; }

    @PostMapping("/orders")
    public int createOrder(@RequestBody OrderRequest orderRequest) {
        return orderService.createOrder(orderRequest);
    }

    @GetMapping("/orders/{ordersNumber}")
    public OrderResponse readOrder(@PathVariable String ordersNumber) {
        return orderService.readOrder(ordersNumber);
    }

    @GetMapping("/user-orders/{userId}")
    public List<OrderDto> readOrderByUserId(@PathVariable String userId) {
        return orderService.selectOrderListByUserId(userId);
    }

    @DeleteMapping("/orders/{ordersNumber}")
    public int deleteOrder(@PathVariable String ordersNumber) {
        return orderService.deleteOrder(ordersNumber);
    }
}
