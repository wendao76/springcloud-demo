package com.github.wendao76.springcloud.websocket.config;

import org.springframework.stereotype.Component;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.reactive.CorsConfigurationSource;
import org.springframework.web.reactive.socket.WebSocketHandler;
import org.springframework.web.reactive.socket.WebSocketSession;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * @Description 类描述信息
 * @ClassName EchoHandler
 * @Author lwh
 * @Date 2020-4-1 19:33
 * @Version 1.0
 */

@Component
@WebSocketMapping("/ws/echo")
public class EchoHandler implements WebSocketHandler, CorsConfigurationSource {
	public Mono<Void> handle(WebSocketSession session) {
		return session.send(
				session.receive().map(
						msg -> session.textMessage("From Client -> " + msg.getPayloadAsText())));
	}

	@Override
	public CorsConfiguration getCorsConfiguration(ServerWebExchange exchange) {
		CorsConfiguration configuration = new CorsConfiguration();
		configuration.addAllowedOrigin("*");
		return configuration;
	}
}