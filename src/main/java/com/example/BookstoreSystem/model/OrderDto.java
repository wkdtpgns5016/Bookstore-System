package com.example.BookstoreSystem.model;

import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Setter
@Getter
public class OrderDto {
    String number;
    Timestamp date;
    int totalAmount;
    String cardNumber;
    String cardExpirationDate;
    String cardType;
    String userId;
    String addressZoneCode;
    String defaultAddress;
    String detailAddress;
    String state;
}
