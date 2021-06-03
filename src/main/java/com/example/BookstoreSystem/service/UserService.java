package com.example.BookstoreSystem.service;

import com.example.BookstoreSystem.model.UserDto;

import java.util.List;

public interface UserService {
    public List selectUserList();
    public UserDto selectUserInfo(String userId);
}
