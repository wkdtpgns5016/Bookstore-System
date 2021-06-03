package com.example.BookstoreSystem.service;

import com.example.BookstoreSystem.dao.UserDao;
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
    public UserDto selectUserInfo(String userId) { return userDao.selectUserInfo(userId); }
}
