package com.github.wendao76.controller;

import com.github.wendao76.component.AsyncTaskCreator;
import com.github.wendao76.config.annotation.RequestEntity;
import com.github.wendao76.model.ReqEntity;
import com.github.wendao76.model.RespEntity;
import com.squareup.okhttp.OkHttpClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;

import java.util.concurrent.Callable;

/**
 * @Description 异步网关控制器
 * @ClassName GatewayController
 * @Author lwh
 * @Date 2020/3/23 10:57
 * @Version 1.0
 */
@RestController
@RequestMapping("/async")
public class GatewayController {
	@Autowired
	OkHttpClient okHttpClient;

	@Autowired
	AsyncTaskCreator asyncTaskCreator;

	@RequestMapping("/1")
	public Callable<RespEntity> indexAsync(@RequestEntity ReqEntity reqEntity) {
		return asyncTaskCreator.newCallable(reqEntity);
	}

	@RequestMapping("/2")
	public DeferredResult<RespEntity> indexAsync2(@RequestEntity ReqEntity reqEntity) {
		return asyncTaskCreator.newDeferredResult(reqEntity);
	}
}
