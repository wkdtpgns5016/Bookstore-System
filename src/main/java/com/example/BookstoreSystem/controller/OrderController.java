package com.example.BookstoreSystem.controller;

import com.example.BookstoreSystem.model.OrderDto;
import com.example.BookstoreSystem.model.OrderSelectionDto;
import com.example.BookstoreSystem.service.OrderService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OrderController {
    private final OrderService orderService;
    public OrderController(OrderService orderService) { this.orderService = orderService; }

    @GetMapping("/orders")
    public List<OrderDto> selectOrderList() { return orderService.selectOrderList(); }

    @GetMapping("/orders/{number}")
    public OrderDto selectOrderInfo(@PathVariable int number) { return orderService.selectOrderInfo(number); }

    @PostMapping("/orders")
    public int insertOrderInfo(@RequestBody OrderDto order) { return orderService.insertOrderInfo(order); }

    @PutMapping("/orders")
    public int updateOrderInfo(@RequestBody OrderDto order) { return orderService.updateOrderInfo(order); }

    @DeleteMapping("/orders/{number}")
    public int deleteOrderInfo(@PathVariable int number) { return orderService.deleteOrderInfo(number); }

    @GetMapping("/order-selections/{orderNumber}")
    public List<OrderSelectionDto> selectOrderSelectionByOrderNumber(@PathVariable int orderNumber) {
        return orderService.selectOrderSelectionByOrderNumber(orderNumber);
    }
}
