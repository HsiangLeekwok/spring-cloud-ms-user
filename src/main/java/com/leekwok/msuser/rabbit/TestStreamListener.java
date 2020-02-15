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

    /**
     * condition 属性支持 SpEL 表达
     * @param message
     */
    @StreamListener(value = Sink.INPUT, condition = "headers['version']=='v1'")
    public void testV1(String message) {
        Logger.info("消费 v1 版本的消息: {}", message);
    }

    @StreamListener(value = Sink.INPUT, condition = "headers['version']=='v2'")
    public void testV2(String message) {
        Logger.info("消费 v2 版本的消息: {}", message);
    }

    @StreamListener(MySink.MY_INPUT)
    public void test2(String message) {
        Logger.info("message2(custom interface) is: {}", message);
    }

    /**
     * 全局处理异常
     *
     * @param message 原始的消息
     */
    @StreamListener("errorChannel")
    public void error(Message<?> message) {
        ErrorMessage errorMessages = (ErrorMessage) message;
        Logger.warn("handler wan {}", errorMessages);
    }
}
