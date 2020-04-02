package com.github.wendao76.springcloud.serviceconsumerdemo.controller;

import com.github.wendao76.springcloud.serviceconsumerdemo.service.HelloRemote;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author wendao76
 */
//@RestController
//@RequestMapping("/consumer")
public class HelloController {
    @Autowired
    HelloRemote helloRemote;

    @GetMapping(value = "/hello")
    public String index(@RequestParam String name) {
        return helloRemote.hello(name);
    }
}
