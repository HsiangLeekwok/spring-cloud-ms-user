package com.leekwok.msuser.rabbit;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

/**
 * <b>Author</b>: Hsiang Leekwok<br/>
 * <b>Date</b>: 2020/02/12 01:15<br/>
 * <b>Version</b>: v1.0<br/>
 * <b>Subject</b>: <br/>
 * <b>Description</b>:
 */
public interface MySink {

    String MY_INPUT = "myInput";

    @Input(MY_INPUT)
    SubscribableChannel input();
}
