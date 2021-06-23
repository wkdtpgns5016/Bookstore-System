package com.example.BookstoreSystem.model;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class BookDto {
    int id;
    String title;
    int inventory;
    int price;
}
