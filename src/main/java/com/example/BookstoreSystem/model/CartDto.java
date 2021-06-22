package com.example.BookstoreSystem.model;

import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
public class CartDto {
    int id;
    String userId;
    Timestamp creationDate;
}
