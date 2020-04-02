package com.github.wendao76.springcloud.component.mq;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Description 类描述信息
 * @ClassName MQSenderClient
 * @Author tiger
 * @Date 2020/3/23 14:42
 * @Version 1.0
 */
@Component
public class MqSenderClient {
	@Autowired
	RabbitTemplate rabbitTemplate;

	@Autowired
	CustomMqProperty customMqProperty;

	public boolean sendMsg(Object obj) {
		rabbitTemplate.convertAndSend("gpx-test", "key01", obj);
		return true;
	}

	public boolean sendMsg2(Object obj) {
		rabbitTemplate.convertAndSend(customMqProperty.getExchangeName(), customMqProperty.getDefaultRouteKey(), obj);
		return true;
	}
}
