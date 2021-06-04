package com.example.BookstoreSystem.controller;

import com.example.BookstoreSystem.model.UserAddressDto;
import com.example.BookstoreSystem.model.UserCardDto;
import com.example.BookstoreSystem.model.UserDto;
import com.example.BookstoreSystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    private final UserService userService;
    public UserController(UserService userService) { this.userService = userService; }

    @GetMapping("/users")
    public List<UserDto> selectUserList() { return userService.selectUserList(); }

    @GetMapping("/users/{userId}")
    public UserDto selectUserInfo(@PathVariable String userId) { return userService.selectUserInfo(userId); }

    @GetMapping("/user-addresses/{userId}")
    public List<UserAddressDto> selectUserAddressInfo(@PathVariable String userId) { return userService.selectUserAddressInfo(userId); }

    @GetMapping("/user-cards/{userId}")
    public List<UserCardDto> selectUserCardInfo(@PathVariable String userId) { return userService.selectUserCardInfo(userId); }

    @PostMapping("/users")
    public int insertUserInfo(@RequestBody UserDto user){ return userService.insertUserInfo(user); }

    @PostMapping("/user-addresses")
    public int insertUserAddressInfo(@RequestBody UserAddressDto address){ return userService.insertUserAddressInfo(address); }

    @PostMapping("/user-cards")
    public int insertUserCardInfo(@RequestBody UserCardDto card){ return userService.insertUserCardInfo(card); }

    @PutMapping("/users")
    public int updateUserInfo(@RequestBody UserDto user){ return userService.updateUserInfo(user); }

    @PutMapping("/user-addresses")
    public int updateUserAddressInfo(@RequestBody UserAddressDto address){ return userService.updateUserAddressInfo(address); }

}
