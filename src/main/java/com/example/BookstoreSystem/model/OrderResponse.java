package com.example.BookstoreSystem.model;

import lombok.Data;

import java.sql.Timestamp;
import java.util.List;

@Data
public class OrderResponse {
    String number;
    String userId;
    Timestamp date;
    int totalAmount;
    String state;
    Card card;
    Address address;
    List<Order> orders;

    @Data
    static public class Card {
        String cardNumber;
        String cardExpirationDate;
        String cardType;
    }

    @Data
    static public class Address {
        String addressZoneCode;
        String defaultAddress;
        String detailAddress;
    }

    @Data
    static public class Order {
        BookDto book;
        int quantity;
        int price;

        public void setPrice() {
            this.price = book.getPrice() * quantity;
        }
    }
}
