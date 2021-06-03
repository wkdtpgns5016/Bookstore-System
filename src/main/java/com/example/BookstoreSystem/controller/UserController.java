package com.example.BookstoreSystem.controller;

import com.example.BookstoreSystem.model.UserDto;
import com.example.BookstoreSystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;
    public UserController(UserService userService) { this.userService = userService; }

    @GetMapping("")
    public List<UserDto> selectUserList() {
        return userService.selectUserList();
    }

    @GetMapping("{userId}")
    public UserDto selectUserInfo(@PathVariable String userId) { return userService.selectUserInfo(userId); }
}
