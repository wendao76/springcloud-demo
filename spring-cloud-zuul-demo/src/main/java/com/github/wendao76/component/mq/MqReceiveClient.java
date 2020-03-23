package com.github.wendao76.component.mq;

import com.github.wendao76.component.AsyncTaskHandler;
import com.github.wendao76.model.RespEntity;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Service;

/**
 * @Description 队列监听器
 * @ClassName MQSenderClient
 * @Author lwh
 * @Date 2020/3/23 14:42
 * @Version 1.0
 */
@Service
public class MqReceiveClient {
	@Autowired
	MqAdmin mqAdmin;

	@Autowired
	@Qualifier("deferredResultPoolTaskExecutor")
	ThreadPoolTaskExecutor taskExecutor;

	@RabbitListener(queues = {"queue-async-task"})
	public void receive01(Message message) {
		byte[] body = message.getBody();
		System.out.println("receive01 = " + new String(body));
	}

	@RabbitListener(queues = {"queue-async-task-${appInstanceId}"})
	public void receive02(Message message) {
		byte[] body = message.getBody();
		//TODO 数据转转对象
		RespEntity respEntity = new RespEntity();
		respEntity.setRequestId("aaaaaaaa");
		taskExecutor.execute(new AsyncTaskHandler(respEntity));
		System.out.println("receive02 = " + new String(body));
	}
}
