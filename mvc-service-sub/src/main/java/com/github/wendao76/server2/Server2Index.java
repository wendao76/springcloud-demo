package com.github.wendao76.server2;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;

/**
 * @author wendao76
 * @version 1.0
 * @description 类描述信息
 * @className Server2Index
 * @date 2020-9-28 16:58
 */
@RestController
@RequestMapping("/api/v2")
public class Server2Index {

    @PostConstruct
    public void init() {
        System.out.println("Server2Index.init");
    }

    @RequestMapping("/index")
    public String index() {
        return "testtest";
    }
}
