package com.github.wendao76.serviceproviderdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * 服务提供者
 * @author wendao76
 */
@SpringBootApplication
@EnableDiscoveryClient
public class ServiceProviderDemoApplication {
    public static void main(String[] args) {
        SpringApplication.run(ServiceProviderDemoApplication.class, args);
    }
}
