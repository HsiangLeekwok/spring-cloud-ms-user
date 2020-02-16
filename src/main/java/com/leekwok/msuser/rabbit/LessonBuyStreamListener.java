package com.leekwok.msuser.rabbit;

import com.leekwok.msuser.dto.UserMoneyDTO;
import com.leekwok.msuser.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.stereotype.Component;

/**
 * <b>Author</b>: Hsiang Leekwok<br/>
 * <b>Date</b>: 2020/02/15 21:36<br/>
 * <b>Version</b>: v1.0<br/>
 * <b>Subject</b>: <br/>
 * <b>Description</b>:
 */
@Component
public class LessonBuyStreamListener {

    @Autowired
    private UserService userService;

    @StreamListener(Sink.INPUT)
    public void lessonBuy(UserMoneyDTO moneyDTO) {

        this.userService.lessonBuy(moneyDTO);
    }
}
