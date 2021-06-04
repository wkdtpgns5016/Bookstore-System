package com.example.BookstoreSystem.service;

import com.example.BookstoreSystem.dao.UserDao;
import com.example.BookstoreSystem.model.UserAddressDto;
import com.example.BookstoreSystem.model.UserCardDto;
import com.example.BookstoreSystem.model.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("UserService")
public class UserServiceImpl implements UserService{
    final
    UserDao userDao;
    public UserServiceImpl(UserDao userDao) { this.userDao = userDao; }

    @Override
    public List selectUserList() { return userDao.selectUserList(); }

    @Override
    public UserDto selectUserInfo(String userId) { return userDao.selectUserInfo(userId); }

    @Override
    public List<UserAddressDto> selectUserAddressInfo(String userId) { return userDao.selectUserAddressInfo(userId); }

    @Override
    public List<UserCardDto> selectUserCardInfo(String userId) { return userDao.selectUserCardInfo(userId); }

    @Override
    public int insertUserInfo(UserDto user) { return userDao.insertUserInfo(user); }

    @Override
    public int insertUserAddressInfo(UserAddressDto address) { return userDao.insertUserAddressInfo(address); }

    @Override
    public int insertUserCardInfo(UserCardDto card) { return userDao.insertUserCardInfo(card); }

    @Override
    public int updateUserInfo(UserDto user) { return userDao.updateUserInfo(user); }

    @Override
    public int updateUserAddressInfo(UserAddressDto address) { return userDao.updateUserAddressInfo(address); }

    @Override
    public int updateUserCardInfo(UserCardDto card) { return userDao.updateUserCardInfo(card); }

}
