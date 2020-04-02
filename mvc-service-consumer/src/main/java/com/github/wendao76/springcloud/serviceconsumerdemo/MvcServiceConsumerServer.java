package com.github.wendao76.springcloud.serviceconsumerdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * 服务消费者
 *
 * @author wendao76
 */
@SpringBootApplication
@EnableFeignClients
@EnableEurekaClient
public class MvcServiceConsumerServer {

    public static void main(String[] args) {
        SpringApplication.run(MvcServiceConsumerServer.class, args);
    }

}
