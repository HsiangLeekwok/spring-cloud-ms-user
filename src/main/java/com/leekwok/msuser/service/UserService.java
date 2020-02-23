package com.leekwok.msuser.service;

import com.leekwok.msuser.dto.UserLoginDTO;
import com.leekwok.msuser.dto.UserMoneyDTO;
import com.leekwok.msuser.entity.User;
import com.leekwok.msuser.entity.UserAccountEventLog;
import com.leekwok.msuser.jwt.JwtOperator;
import com.leekwok.msuser.repository.UserAccountEventLogRepository;
import com.leekwok.msuser.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.Optional;

/**
 * <b>Author</b>: Xiang Liguo<br/>
 * <b>Date</b>: 2020/01/15 13:54<br/>
 * <b>Version</b>: 1.0<br/>
 * <b>Subject</b>: <br/>
 * <b>Description</b>:
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserAccountEventLogRepository userAccountEventLogRepository;

    @Autowired
    private JwtOperator jwtOperator;

    /**
     * 根据 id 查找用户信息
     */
    public User findById(Integer id) {
        // Optional 是 jdk8 的新特性，用来优雅的处理空指针问题
        return this.userRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("User is not exists."));
    }

    public void lessonBuy(UserMoneyDTO moneyDTO) {
        // 1. 接受消息
        // 2. 扣减余额
        Integer userId = moneyDTO.getUserId();
        BigDecimal money = moneyDTO.getMoney();
        Optional<User> optionalUser = this.userRepository.findById(userId);

        User user = optionalUser.orElseThrow(() -> new IllegalArgumentException("用户 id 不存在"));
        user.setMoney(user.getMoney().subtract(money));
        this.userRepository.save(user);
        // 3. 记录日志 user_account_event_log
        this.userAccountEventLogRepository.save(
                new UserAccountEventLog(
                        userId,
                        money,
                        moneyDTO.getEvent(),
                        moneyDTO.getDescription(),
                        new Date()
                )
        );
    }

    public String login(UserLoginDTO loginDTO) {
        // 1. 校验账号密码(直接使用明文，MD5/SHA1等)是否匹配
        // 让 spring data jpa 发送处理语句
        return this.userRepository.findByUsernameAndPassword(loginDTO.getUsername(), loginDTO.getPassword())
                .map(user -> {
                    // 2. 如果匹配，则颁发 token
                    HashMap<String, Object> map = new HashMap<>();
                    map.put("userId", user.getId());
                    map.put("username", user.getUsername());
                    map.put("role", "vip");

                    return jwtOperator.generateToken(map);
                })
                .orElseThrow(() -> new IllegalArgumentException("账号密码不匹配"));
    }
}
