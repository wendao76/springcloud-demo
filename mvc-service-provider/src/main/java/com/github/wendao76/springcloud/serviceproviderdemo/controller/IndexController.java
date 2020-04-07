package com.github.wendao76.springcloud.serviceproviderdemo.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/v1")
public class IndexController {
    @Value("${spring.application.name}")
    String appName;

    @PostMapping("/hello")
    public String hello(HttpServletRequest request) {
        String accessToken = request.getHeader("access_token");
        return "Hello " + appName;
    }
}
