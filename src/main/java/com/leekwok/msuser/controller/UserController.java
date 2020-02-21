package com.leekwok.msuser.controller;

import com.leekwok.msuser.auth.Login;
import com.leekwok.msuser.dto.UserLoginDTO;
import com.leekwok.msuser.entity.User;
import com.leekwok.msuser.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <b>Author</b>: Xiang Liguo<br/>
 * <b>Date</b>: 2020/01/15 13:59<br/>
 * <b>Version</b>: 1.0<br/>
 * <b>Subject</b>: <br/>
 * <b>Description</b>:
 */
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 1. 如果用户已经登录了，正常返回
     * 2. 如果用户未登录，返回401
     */
    @Login
    @GetMapping("/users/{id}")
    public User findById(@PathVariable Integer id) {
        return this.userService.findById(id);
    }

    @PostMapping("/login")
    public String login(@RequestBody UserLoginDTO loginDTO) {
        return this.userService.login(loginDTO);
    }
}
