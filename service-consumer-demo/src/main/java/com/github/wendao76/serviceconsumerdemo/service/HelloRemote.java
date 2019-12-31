package com.github.wendao76.serviceconsumerdemo.service;


import com.github.wendao76.serviceconsumerdemo.service.hystrix.HelloRemoteHystrix;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 远程服务调用
 * @author wendao76
 */
@FeignClient(name= "spring-service-producer", fallback = HelloRemoteHystrix.class)
public interface HelloRemote {
    @GetMapping("/producer/hello")
    String hello(@RequestParam(value = "name") String name);
}
