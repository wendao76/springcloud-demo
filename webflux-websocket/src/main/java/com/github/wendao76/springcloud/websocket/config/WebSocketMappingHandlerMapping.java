package com.github.wendao76.springcloud.websocket.config;

import org.springframework.beans.BeansException;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.web.reactive.handler.SimpleUrlHandlerMapping;
import org.springframework.web.reactive.socket.WebSocketHandler;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

/**
 * websocket映射服务
 *
 * @Description websocket映射服务
 * @ClassName WebSocketMappingHandlerMapping
 * @Author tiger
 * @Date 2020-4-1 19:40
 * @Version 1.0
 */
public class WebSocketMappingHandlerMapping extends SimpleUrlHandlerMapping {
	private Map<String, WebSocketHandler> handlerMap = new LinkedHashMap<>();

	/**
	 * Register WebSocket handlers annotated by @WebSocketMapping
	 *
	 * @throws BeansException
	 */
	@Override
	public void initApplicationContext() throws BeansException {
		Map<String, Object> beanMap = obtainApplicationContext()
				.getBeansWithAnnotation(WebSocketMapping.class);
		beanMap.values().forEach(bean -> {
			if (!(bean instanceof WebSocketHandler)) {
				throw new RuntimeException(
						String.format("Controller [%s] doesn't implement WebSocketHandler interface.",
								bean.getClass().getName()));
			}
			WebSocketMapping annotation = AnnotationUtils.getAnnotation(
					bean.getClass(), WebSocketMapping.class);
			//webSocketMapping 映射到管理中
			handlerMap.put(Objects.requireNonNull(annotation).value(), (WebSocketHandler) bean);
		});
		super.setOrder(Ordered.HIGHEST_PRECEDENCE);
		super.setUrlMap(handlerMap);
		super.initApplicationContext();
	}
}
