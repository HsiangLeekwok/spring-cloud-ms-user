package com.leekwok.msuser.rabbit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.ErrorMessage;
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
       // throw new RuntimeException("发生了一个消息消费异常");
    }

    @StreamListener(MySink.MY_INPUT)
    public void test2(String message) {
        Logger.info("message2(custom interface) is: {}", message);
    }

    /**
     * 全局处理异常
     * @param message 原始的消息
     */
    @StreamListener("errorChannel")
    public void error(Message<?> message) {
        ErrorMessage errorMessages = (ErrorMessage) message;
        Logger.warn("handler wan {}", errorMessages);
    }
}
