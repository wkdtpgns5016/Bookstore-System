package com.example.BookstoreSystem.model;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class AddCartDto {
    int cardId;
    int bookId;
    int quantity;
}
