package com.example.BookstoreSystem.model;

import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Setter
@Getter
public class UserCardDto {
    String userId;
    String number;
    String expirationDate;
    String type;
}
