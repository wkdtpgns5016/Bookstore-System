package com.example.BookstoreSystem.model;

import lombok.Data;

import java.sql.Timestamp;
import java.util.List;

@Data
public class CartResponse {
    String id;
    String userId;
    Timestamp creationDate;
    List<AddCartDto> carts;
}
