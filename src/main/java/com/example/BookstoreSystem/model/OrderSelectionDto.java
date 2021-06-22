package com.example.BookstoreSystem.model;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class OrderSelectionDto {
    int orderNumber;
    int bookId;
    int quantity;
}
