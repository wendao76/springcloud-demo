package com.github.wendao76.serviceconsumerdemo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wendao76
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @GetMapping(value = "/info")
    public String userInfo() {
        return "I am userInfo";
    }
}
