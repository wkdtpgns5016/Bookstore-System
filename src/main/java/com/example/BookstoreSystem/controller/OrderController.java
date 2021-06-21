package com.example.BookstoreSystem.controller;

import com.example.BookstoreSystem.model.OrderDto;
import com.example.BookstoreSystem.service.OrderService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OrderController {
    private final OrderService orderService;
    public OrderController(OrderService orderService) { this.orderService = orderService; }

    @GetMapping("")
    public List<OrderDto> selectOrderList() { return orderService.selectOrderList(); }

    @GetMapping("/{number}")
    public OrderDto selectOrderInfo(@PathVariable int number) { return orderService.selectOrderInfo(number); }

    @PostMapping("")
    public int insertOrderInfo(@RequestBody OrderDto order) { return orderService.insertOrderInfo(order); }
}
