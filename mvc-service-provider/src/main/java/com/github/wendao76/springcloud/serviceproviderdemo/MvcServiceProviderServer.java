package com.github.wendao76.springcloud.serviceproviderdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * 服务提供者
 * TODO 暂时屏蔽服务发现
 *
 * @author wendao76
 */
@EnableDiscoveryClient
@SpringBootApplication
public class MvcServiceProviderServer {
    public static void main(String[] args) {
        SpringApplication.run(MvcServiceProviderServer.class, args);
    }
}
