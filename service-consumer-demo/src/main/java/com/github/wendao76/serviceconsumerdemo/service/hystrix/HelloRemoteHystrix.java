package com.github.wendao76.serviceconsumerdemo.service.hystrix;


import com.github.wendao76.serviceconsumerdemo.service.HelloRemote;
import org.springframework.stereotype.Component;

/**
 * 熔断处理
 * @author wendao76
 */
@Component
public class HelloRemoteHystrix implements HelloRemote {
    @Override
    public String hello(String name) {
        return "visit failed";
    }
}
