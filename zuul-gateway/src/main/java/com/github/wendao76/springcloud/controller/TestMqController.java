package com.github.wendao76.springcloud.controller;

import com.github.wendao76.springcloud.component.AsyncTaskCreator;
import com.github.wendao76.springcloud.component.mq.MqSenderClient;
import com.github.wendao76.springcloud.config.annotation.RequestEntity;
import com.github.wendao76.springcloud.model.ReqEntity;
import com.github.wendao76.springcloud.model.RespEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;

/**
 * @Description 类描述信息
 * @ClassName GatewayController
 * @Author tiger
 * @Date 2020/3/23 10:57
 * @Version 1.0
 */
@RestController
@RequestMapping("/mq")
public class TestMqController {
	@Value("${appInstanceId}")
	String appInstanceId;

	@Autowired
	AsyncTaskCreator asyncTaskCreator;

	@Autowired
	MqSenderClient mqSenderClient;

	@PostMapping("/send")
	public Object index(@RequestEntity ReqEntity reqEntity) {
		mqSenderClient.sendMsg(reqEntity);
		return "test";
	}

	@PostMapping("/send2")
	public Object index2(@RequestEntity ReqEntity reqEntity) {
		mqSenderClient.sendMsg2(reqEntity);
		return "test";
	}

	@PostMapping("/send3")
	public DeferredResult<RespEntity> index3(@RequestEntity ReqEntity reqEntity) {
		return asyncTaskCreator.newDeferredResult(reqEntity);
	}
}
