package com.github.wendao76.springcloud.zuuldemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableZuulProxy
//@EnableEurekaClient
@ComponentScan(basePackages = {"com.github.wendao76.*"})
public class ZuulServer {
    public static void main(String[] args) {
        SpringApplication app = new SpringApplicationBuilder(ZuulServer.class).build(args);
        app.addListeners(new AppStartListener(), new AppStopListener(), new EnvPreparedListener());
        app.run(args);
    }

}
