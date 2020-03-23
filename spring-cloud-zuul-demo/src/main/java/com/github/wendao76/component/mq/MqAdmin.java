package com.github.wendao76.component.mq;

import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * @Description 类描述信息
 * @ClassName MqAdmin
 * @Author tiger
 * @Date 2020/3/23 16:38
 * @Version 1.0
 */
@Service
public class MqAdmin {
	@Value("${appInstanceId}")
	public String appInstanceId;

	@Autowired
	CustomMqProperty customMqProperty;

	@Autowired
	private AmqpAdmin amqpAdmin;

	@PostConstruct
	public void createAsyncTaskBinding() {
		String queueName = customMqProperty.getQueueNamePre() + "-" + appInstanceId;
		String exchangeName = customMqProperty.getExchangeName();

		//参数  交换器名， durable 是否持久化， autoDelete 是否自动删除
		Exchange exchange = new DirectExchange(exchangeName, true, false);
		amqpAdmin.declareExchange(exchange);
		//创建队列
		amqpAdmin.declareQueue(new Queue(queueName));
		// 创建绑定关系
		// destination 绑定的目的地, Binding.DestinationType destinationType 绑定的类型是交换器还是队列,
		// String exchange 绑定到那个交换器上, String routingKey  路由键, Map<String, Object> arguments 命令参数
		Binding binding =
				new Binding(
						queueName, Binding.DestinationType.QUEUE, exchangeName, customMqProperty.getDefaultRouteKey(), null);
		amqpAdmin.declareBinding(binding);
	}

	@PreDestroy
	public void removeAsyncTaskBinding() {
		System.out.println("removeAsyncTaskBinding");
		String queueName = customMqProperty.getQueueNamePre() + "-" + appInstanceId;
		String exchangeName = customMqProperty.getExchangeName();

		//删除绑定关系
		amqpAdmin.removeBinding(new Binding(
				queueName, Binding.DestinationType.QUEUE, exchangeName, appInstanceId, null));
		//删除队列(这个还可以再讨论)
		amqpAdmin.deleteQueue(queueName);
	}

}
