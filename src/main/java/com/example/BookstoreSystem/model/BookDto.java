package com.example.BookstoreSystem.model;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class BookDto {
    String id;
    String title;
    int inventory;
    int price;
}
