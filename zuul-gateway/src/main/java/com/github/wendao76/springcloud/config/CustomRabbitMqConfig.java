package com.github.wendao76.springcloud.config;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Description 类描述信息
 * @ClassName CustomRabbitMqConfig
 * @Author tiger
 * @Date 2020/3/23 14:44
 * @Version 1.0
 */
@EnableRabbit
@Configuration
public class CustomRabbitMqConfig {
	@Bean
	public MessageConverter messageConverter() {
		return new Jackson2JsonMessageConverter();
	}
}
