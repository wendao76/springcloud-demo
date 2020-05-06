package com.github.wendao76.springcloud.gateway.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Description 类描述信息
 * @ClassName MessageBalanceConfig
 * @Author wendao76
 * @Date 2020-4-16 19:43
 * @Version 1.0
 */
@Configuration
@AvoidScan
public class MyBalanceConfig {
	@Bean
	public MyBalanceRule messageBalanceRule() {
		return new MyBalanceRule();
	}
}
