package com.example.BookstoreSystem.service;

import com.example.BookstoreSystem.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("UserService")
public class UserServiceImpl implements UserService{
    @Autowired
    UserDao userDao;

    @Override
    public List getAllUsers() { return userDao.getAllUsers(); }
}
