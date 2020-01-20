package com.leekwok.msuser.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <b>Author</b>: Xiang Liguo<br/>
 * <b>Date</b>: 2020/01/20 15:47<br/>
 * <b>Version</b>: 1.0<br/>
 * <b>Subject</b>: <br/>
 * <b>Description</b>:
 */
@RestController
public class TestController {
    // 如果不使用 consul 管理的话，这个配置属性会在 application.yml 里读取
    @Value("${first.config}")
    private String config;

    @GetMapping("/test-config")
    public String getConfig() {
        return this.config;
    }
}
