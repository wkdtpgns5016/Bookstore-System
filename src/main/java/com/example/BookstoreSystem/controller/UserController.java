package com.example.BookstoreSystem.controller;

import com.example.BookstoreSystem.model.UserAddressDto;
import com.example.BookstoreSystem.model.UserCardDto;
import com.example.BookstoreSystem.model.UserDto;
import com.example.BookstoreSystem.model.UserResponse;
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
    public UserResponse getUser(@PathVariable String userId) { return userService.getUser(userId); }

    @PostMapping("/users")
    public int signUp(@RequestBody UserDto user){ return userService.insertUserInfo(user); }

    @PostMapping("/user-addresses")
    public int CreateAddress(@RequestBody UserAddressDto address){ return userService.insertUserAddressInfo(address); }

    @PostMapping("/user-cards")
    public int CreateCard(@RequestBody UserCardDto card){ return userService.insertUserCardInfo(card); }

    @PutMapping("/users")
    public int updateUserInfo(@RequestBody UserDto user){ return userService.updateUserInfo(user); }

    @PutMapping("/user-addresses")
    public int updateUserAddressInfo(@RequestBody UserAddressDto address){ return userService.updateUserAddressInfo(address); }

    @PutMapping("/user-cards")
    public int updateUserCardInfo(@RequestBody UserCardDto card){ return userService.updateUserCardInfo(card); }

    @DeleteMapping("/users/{userId}")
    public int deleteUser(@PathVariable String userId) { return userService.deleteUser(userId); }
}
