package com.github.wendao76.springcloud.websocket.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.HandlerMapping;
import org.springframework.web.reactive.socket.server.support.WebSocketHandlerAdapter;

/**
 * websocket配置
 *
 * @Description websocket配置
 * @ClassName WebSocketConfiguration
 * @Author tiger
 * @Date 2020-4-1 19:34
 * @Version 1.0
 */
@Configuration
public class WebSocketConfiguration {
	@Bean
	public HandlerMapping webSocketMapping() {
		return new WebSocketMappingHandlerMapping();
	}

	@Bean
	public WebSocketHandlerAdapter handlerAdapter() {
		return new WebSocketHandlerAdapter();
	}
}
