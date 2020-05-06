package com.github.wendao76.springcloud.gateway;

import com.github.wendao76.springcloud.gateway.config.AvoidScan;
import com.github.wendao76.springcloud.gateway.config.MyBalanceConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;

/**
 * 基于webflux的websocket
 *
 * @Description 基于webflux的websocket
 * @ClassName WebFluxWebsocketServer
 * @Author wendao76
 * @Date 2020-4-2 11:05
 * @Version 1.0
 */
@SpringBootApplication
@ComponentScan(basePackages = {"com.github.wendao76.springcloud.*"},
		excludeFilters = {@ComponentScan.Filter(type = FilterType.ANNOTATION, value = AvoidScan.class)})
@EnableEurekaClient
@Slf4j
@RibbonClient(name = "some-server-id", configuration = MyBalanceConfig.class)
public class ScGatewayServer {
	public static void main(String[] args) {
		SpringApplication app = new SpringApplicationBuilder(ScGatewayServer.class).build(args);
		app.run(args);
	}
}
