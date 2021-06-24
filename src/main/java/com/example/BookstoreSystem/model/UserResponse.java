package com.example.BookstoreSystem.model;

import lombok.Data;

import java.util.List;

@Data
public class UserResponse {
    String id;
    String password;
    String name;
    List<UserAddressDto> addresses;
    List<UserCardDto> cards;
}
