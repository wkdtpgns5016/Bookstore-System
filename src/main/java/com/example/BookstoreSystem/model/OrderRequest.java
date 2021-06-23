package com.example.BookstoreSystem.model;

import lombok.Data;

import java.util.List;

@Data
public class OrderRequest {
    String userId;
    String cardNumber;
    String cardExpirationDate;
    String cardType;
    String addressZoneCode;
    String defaultAddress;
    String detailAddress;
    List<OrderSelectionDto> orders;
}
