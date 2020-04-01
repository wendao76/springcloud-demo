package com.github.wendao76.config;

import com.github.wendao76.component.websocket.SocketHandler;
import com.github.wendao76.component.websocket.SocketSessionHolder;
import com.github.wendao76.component.websocket.WebSocketInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

/**
 * @Description 类描述信息
 * @ClassName WebSocketConfig
 * @Author tiger
 * @Date 2020/3/24 17:55
 * @Version 1.0
 */
@Configuration
@EnableWebSocket
public class WebSocketConfig implements WebSocketConfigurer {
	@Override
	public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
		registry.addHandler(myHandler(), "/websocket/**")
				.addInterceptors(new WebSocketInterceptor())
				.setAllowedOrigins("*");
	}

	@Bean
	public SocketHandler myHandler() {
		return new SocketHandler();
	}

	@Bean
	public SocketSessionHolder socketSessionHolder() {
		return new SocketSessionHolder();
	}
}
