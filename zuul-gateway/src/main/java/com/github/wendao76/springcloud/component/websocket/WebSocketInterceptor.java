package com.github.wendao76.springcloud.component.websocket;

import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.server.support.HttpSessionHandshakeInterceptor;

import java.util.Map;

/**
 * @Description websocket拦截器
 * @ClassName WebSocketInterceptor
 * @Author tiger
 * @Date 2020/3/24 17:58
 * @Version 1.0
 */
public class WebSocketInterceptor extends HttpSessionHandshakeInterceptor {
	@Override
	public boolean beforeHandshake(ServerHttpRequest request, ServerHttpResponse response, WebSocketHandler handler, Map<String, Object> map) throws Exception {
		super.beforeHandshake(request, response, handler, map);
		System.out.println("beforeHandshake");
		if (request instanceof ServletServerHttpRequest) {
//			ServletServerHttpRequest serverHttpRequest = (ServletServerHttpRequest) request;
//			HttpSession session = serverHttpRequest.getServletRequest().getSession();
			//TODO 需要从请求当中获取用户信息， 将用户信息与session进行映射（方便后面定向发消息）
		}
		return true;
	}

	@Override
	public void afterHandshake(ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse, WebSocketHandler webSocketHandler, Exception e) {
		System.out.println("afterHandshake");
	}
}
