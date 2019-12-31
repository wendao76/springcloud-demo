package com.github.wendao76.serviceproviderdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * 服务提供者
 * TODO 暂时屏蔽服务发现
 * @author wendao76
 */
@SpringBootApplication
@EnableDiscoveryClient(autoRegister = false)
public class ServiceProviderDemoApplication {
    public static void main(String[] args) {
        SpringApplication.run(ServiceProviderDemoApplication.class, args);
    }
}
