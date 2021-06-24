package com.example.BookstoreSystem.service;

import com.example.BookstoreSystem.dao.UserDao;
import com.example.BookstoreSystem.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("UserService")
public class UserServiceImpl implements UserService{
    private final UserDao userDao;
    private final OrderService orderService;
    private final CartService cartService;
    public UserServiceImpl(UserDao userDao, CartService cartService, OrderService orderService) {
        this.userDao = userDao;
        this.cartService = cartService;
        this.orderService = orderService;
    }

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

    @Override
    public int deleteUserInfo(String userId) {
        userDao.deleteUserAddressList(userId);
        userDao.deleteUserCardList(userId);
        return userDao.deleteUserInfo(userId);
    }

    @Override
    public int deleteUserAddressInfo(String userId, String type) {
        return userDao.deleteUserAddressInfo(userId, type);
    }

    @Override
    public int deleteUserCardInfo(String userId, String number) {
        return userDao.deleteUserCardInfo(userId,number);
    }

    @Override
    public UserResponse getUser(String userId) {
        UserDto user = selectUserInfo(userId);

        UserResponse response = new UserResponse();
        response.setId(user.getId());
        response.setPassword(user.getPassword());
        response.setName(user.getName());
        response.setAddresses(selectUserAddressInfo(userId));
        response.setCards(selectUserCardInfo(userId));

        return response;
    }

    @Override
    public int deleteUser(String userId) {
        List<OrderDto> orderDtos = orderService.selectOrderListByUserId(userId);
        List<CartDto> cartDtos = cartService.selectCartListByUserId(userId);

        for(OrderDto orderDto : orderDtos) {
            orderService.deleteOrder(orderDto.getNumber());
        }
        for(CartDto cartDto : cartDtos) {
            cartService.deleteCart(cartDto.getId());
        }

        return deleteUserInfo(userId);
    }
}
