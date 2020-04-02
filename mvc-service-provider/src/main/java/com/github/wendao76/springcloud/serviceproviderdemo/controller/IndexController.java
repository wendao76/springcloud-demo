package com.github.wendao76.springcloud.serviceproviderdemo.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/v1")
public class IndexController {
    @PostMapping("/hello")
    public String hello(@RequestBody Map<String, Object> params) {
        System.out.println(params.get("a"));
        return "Hello wendao76";
    }
}
