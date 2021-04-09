package com.github.wendao76.springcloud.serviceproviderdemo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/")
public class IndexController {
    @PostConstruct
    public void init() {
        System.out.println("IndexController.init");
    }

    @GetMapping("/hello")
    public String hello(HttpServletRequest request) {
        return "Hello MVC-SERVICE-PRODUCER";
    }
}
