package com.github.wendao76.springcloud.controller;

import com.github.wendao76.springcloud.component.websocket.SocketHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.socket.TextMessage;

import javax.servlet.http.HttpSession;
import javax.websocket.server.ServerEndpoint;

/**
 * @Description socket控制类， 主要用来发消息
 * @ClassName WebSocketController
 * @Author tiger
 * @Date 2020/3/24 18:05
 * @Version 1.0
 */
@Controller
@ServerEndpoint("/ws")
public class WebSocketController {
	static final Logger logger = LoggerFactory.getLogger(WebSocketController.class);

	@Autowired
	SocketHandler handler;

	@RequestMapping("/login/{username}")
	public @ResponseBody
	String login(HttpSession session, @PathVariable("username") String username) {
		System.out.println("登录接口,username=" + username);
		session.setAttribute("username", username);
		System.out.println(session.getAttribute("username"));

		return "成功";
	}

	@RequestMapping("/message")
	public @ResponseBody
	String sendMessage() {
		boolean flag = handler.sendMessageToUser("4", new TextMessage("你好"));
		System.out.println(flag);
		return "发送";
	}
}
