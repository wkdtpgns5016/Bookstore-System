package com.example.BookstoreSystem.model;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UserAddressDto {
    String userId;
    String type;
    String zoneCode;
    String addressDefault;
    String addressDetail;
}
