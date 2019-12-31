package com.github.wendao76.serviceproviderdemo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/producer")
public class IndexController {
    @GetMapping("/hello")
    public String hello(@RequestParam String name) {
        return "Hello "+ name;
    }
}
