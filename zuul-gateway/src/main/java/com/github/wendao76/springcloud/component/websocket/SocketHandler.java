package com.github.wendao76.springcloud.component.websocket;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.AbstractWebSocketHandler;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @Description docker信息处理
 * @ClassName CustomWebSocketHandler
 * @Author tiger
 * @Date 2020/3/24 17:32
 * @Version 1.0
 */
@Slf4j
public class SocketHandler extends AbstractWebSocketHandler {
	//在线用户列表
	private static final Map<String, WebSocketSession> users;
	//用户标识
	private static final String CLIENT_ID = "username";

	static {
		users = new HashMap<>();
	}

	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		System.out.println("成功建立连接");
		String username = getClientId(session);
		System.out.println("用户ID:" + username);
		if (username != null) {
			users.put(username, session);
			session.sendMessage(new TextMessage("成功建立socket连接"));
		}
	}

	@Override
	public void handleTextMessage(WebSocketSession session, TextMessage message) {
		System.out.println(message.getPayload());
		WebSocketMessage wrapperMsg = new TextMessage("server:" + message);
		try {
			session.sendMessage(wrapperMsg);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 发送信息给指定用户
	 *
	 * @param clientId
	 * @param message
	 * @return
	 */
	public boolean sendMessageToUser(String clientId, TextMessage message) {
		System.out.println("发送消息到用户：" + clientId);
		if (users.get(clientId) == null) {
			System.out.println("1313313");
			return false;
		}
		WebSocketSession session = users.get(clientId);
		System.out.println("sendMessage:" + session);
		if (!session.isOpen()) {
			System.out.println("会话未打开");
			return false;
		}
		try {
			session.sendMessage(message);
		} catch (IOException e) {
			System.out.println(e);
			return false;
		}
		return true;
	}

	/**
	 * 广播信息
	 *
	 * @param message
	 * @return
	 */
	public boolean sendMessageToAllUsers(TextMessage message) {
		boolean allSendSuccess = true;
		Set<String> clientIds = users.keySet();
		WebSocketSession session = null;
		for (String clientId : clientIds) {
			try {
				session = users.get(clientId);
				if (session.isOpen()) {
					session.sendMessage(message);
				}
			} catch (IOException e) {
				e.printStackTrace();
				allSendSuccess = false;
			}
		}

		return allSendSuccess;
	}


	@Override
	public void handleTransportError(WebSocketSession session, Throwable exception) throws Exception {
		if (session.isOpen()) {
			session.close();
		}
		System.out.println("连接出错");
		users.remove(getClientId(session));
	}

	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
		System.out.println("连接已关闭：" + status);
		users.remove(getClientId(session));
	}

	@Override
	public boolean supportsPartialMessages() {
		return false;
	}

	/**
	 * 获取用户标识
	 *
	 * @param session
	 * @return
	 */
	private String getClientId(WebSocketSession session) {
		try {
			String clientId = (String) session.getAttributes().get(CLIENT_ID);
			return clientId;
		} catch (Exception e) {
			return null;
		}
	}
}
