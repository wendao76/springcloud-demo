package com.github.wendao76.springcloud.component.websocket;

import org.springframework.web.socket.WebSocketSession;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @Description websocket Session管理器
 * @ClassName SocketSessionHolder
 * @Author tiger
 * @Date 2020/3/25 10:53
 * @Version 1.0
 */
public class SocketSessionHolder extends ConcurrentHashMap<String, WebSocketSession> {
}
