package com.github.wendao76.controller;

import com.github.wendao76.component.AsyncTaskCreator;
import com.github.wendao76.config.annotation.RequestEntity;
import com.github.wendao76.model.ReqEntity;
import com.github.wendao76.model.RespEntity;
import com.squareup.okhttp.Call;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.concurrent.Callable;

/**
 * @Description 类描述信息
 * @ClassName GatewayController
 * @Author tiger
 * @Date 2020/3/23 10:57
 * @Version 1.0
 */
@RestController
@RequestMapping("/")
public class GatewayController {
	@Autowired
	OkHttpClient okHttpClient;

	@RequestMapping("/async")
	public Callable<RespEntity> indexAsync(@RequestEntity ReqEntity reqEntity) {
		System.out.println(reqEntity.getUrl());
		return AsyncTaskCreator.newCallable(reqEntity);
	}

	@RequestMapping("")
	public Object index(@RequestEntity ReqEntity reqEntity) {
		System.out.println(reqEntity.getUrl());
		final Request request = new Request.Builder()
				.url(reqEntity.getUrl())
				.build();
		final Call call = okHttpClient.newCall(request);
		try {
			Response response = call.execute();
			System.out.println(response.body().string());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "test";
	}
}
