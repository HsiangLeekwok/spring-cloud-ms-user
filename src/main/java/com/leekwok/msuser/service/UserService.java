package com.leekwok.msuser.service;

import com.leekwok.msuser.entity.User;
import com.leekwok.msuser.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * <b>Author</b>: Xiang Liguo<br/>
 * <b>Date</b>: 2020/01/15 13:54<br/>
 * <b>Version</b>: 1.0<br/>
 * <b>Subject</b>: <br/>
 * <b>Description</b>:
 */
@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    /**
     * 根据 id 查找用户信息
     */
    public User findById(Integer id) {
        // Optional 是 jdk8 的新特性，用来优雅的处理空指针问题
        return this.userRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("User is not exists."));
    }
}
