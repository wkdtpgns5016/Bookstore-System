package com.example.BookstoreSystem.model;

import lombok.Data;

import java.util.List;

@Data
public class CartRequest {
    String userId;
    List<AddCartDto> carts;
}