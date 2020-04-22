package com.github.wendao76.springcloud.serviceproviderdemo.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/")
public class IndexController {
    @Value("${spring.application.name}")
    String appName;

    @GetMapping("/hello")
    public String hello(HttpServletRequest request) {
        return "Hello MVC-SERVICE-PRODUCER";
    }
}
