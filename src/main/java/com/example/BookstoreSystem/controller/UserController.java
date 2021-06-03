package com.example.BookstoreSystem.controller;

import com.example.BookstoreSystem.model.UserAddressDto;
import com.example.BookstoreSystem.model.UserDto;
import com.example.BookstoreSystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
public class UserController {
    private final UserService userService;
    public UserController(UserService userService) { this.userService = userService; }

    @GetMapping("/users")
    public List<UserDto> selectUserList() { return userService.selectUserList(); }

    @GetMapping("/users{userId}")
    public UserDto selectUserInfo(@PathVariable String userId) { return userService.selectUserInfo(userId); }

    @GetMapping("/user-addresses")
    public List<UserAddressDto> selectUserAddressList() {
        return userService.selectUserAddressList();
    }

    @GetMapping("/user-addresses/{userId}")
    public List<UserAddressDto> selectUserAddressInfo(@PathVariable String userId) { return userService.selectUserAddressInfo(userId); }
}
