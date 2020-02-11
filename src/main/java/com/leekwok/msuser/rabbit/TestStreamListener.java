package com.leekwok.msuser.rabbit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.stereotype.Component;

/**
 * <b>Author</b>: Hsiang Leekwok<br/>
 * <b>Date</b>: 2020/02/12 00:24<br/>
 * <b>Version</b>: v1.0<br/>
 * <b>Subject</b>: <br/>
 * <b>Description</b>:
 */
@Component
public class TestStreamListener {

    public static final Logger Logger = LoggerFactory.getLogger(TestStreamListener.class);

    @StreamListener(Sink.INPUT)
    public void test(String message) {
        Logger.info("message is: {}", message);
    }
}
