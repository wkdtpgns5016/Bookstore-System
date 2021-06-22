package com.example.BookstoreSystem.model;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class AddCartDto {
    String cartId;
    int bookId;
    int quantity;
}
