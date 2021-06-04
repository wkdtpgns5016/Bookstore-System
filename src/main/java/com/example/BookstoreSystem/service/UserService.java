package com.example.BookstoreSystem.service;

import com.example.BookstoreSystem.model.UserAddressDto;
import com.example.BookstoreSystem.model.UserCardDto;
import com.example.BookstoreSystem.model.UserDto;

import java.util.List;

public interface UserService {
    public List selectUserList();
    public UserDto selectUserInfo(String userId);
    public List<UserAddressDto> selectUserAddressInfo(String userId);
    public List<UserCardDto> selectUserCardInfo(String userId);
    public int insertUserInfo(UserDto user);
    public int insertUserAddressInfo(UserAddressDto address);
    public int insertUserCardInfo(UserCardDto card);
    public int updateUserInfo(UserDto user);
    public int updateUserAddressInfo(UserAddressDto address);
    public int updateUserCardInfo(UserCardDto card);
    public int deleteUserInfo(String userId);
    public int deleteUserAddressInfo(String userId, String type);
    public int deleteUserCardInfo(String userId, String number);
}
