package com.example.BookstoreSystem.model;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class OrderSelectionDto {
    String orderNumber;
    int bookId;
    int quantity;
}
