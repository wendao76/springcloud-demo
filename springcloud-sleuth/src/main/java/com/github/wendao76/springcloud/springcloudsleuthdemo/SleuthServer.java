package com.github.wendao76.springcloud.springcloudsleuthdemo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@EnableFeignClients
@SpringBootApplication(scanBasePackages = "com.github.wendao76.springcloud.springcloudsleuthdemo")
@RestController
@RequestMapping
@Slf4j
public class SleuthServer {

    public static void main(String[] args) {
        SpringApplication.run(SleuthServer.class, args);
    }

    @GetMapping("/index")
    public String index() {
        log.info("test");
        return "test";
    }

}
