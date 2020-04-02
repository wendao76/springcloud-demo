package com.github.wendao76.springcloud.component;

import cn.hutool.crypto.digest.DigestUtil;
import cn.hutool.json.JSONUtil;
import com.github.wendao76.springcloud.component.mq.MqSenderClient;
import com.github.wendao76.springcloud.model.ReqEntity;
import com.github.wendao76.springcloud.model.RespEntity;
import com.squareup.okhttp.Call;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.async.DeferredResult;

import java.io.IOException;
import java.util.concurrent.Callable;

/**
 * @Description 异步任务请求工厂
 * @ClassName AsyncCallerTaskFactory
 * @Author tiger
 * @Date 2020/3/20 11:02
 * @Version 1.0
 */
@Service
public class AsyncTaskCreator {
	@Autowired
	MqSenderClient mqSenderClient;

	@Autowired
	OkHttpClient okHttpClient;

	@Value("${appInstanceId}")
	private String appInstanceId;

	/**
	 * @Description Callable 方式异步请求
	 * @Author lwh
	 * @CreatedAt 2020/3/20 16:20
	 * @UpdatedAt 2020/3/20 16:20
	 * @Param [reqParam]
	 * @Return java.util.concurrent.Callable<cn.com.bosssoft.gpmscloud.openapi.controller.common.RespResult>
	 */
	public Callable<RespEntity> newCallable(ReqEntity reqParam) {
		return new Callable<RespEntity>() {
			@Override
			public RespEntity call() throws Exception {
				return sendRequest(reqParam);
			}
		};
	}

	/**
	 * @Description 创建延期结果
	 * @Author lwh
	 * @CreatedAt 2020/3/20 15:05
	 * @UpdatedAt 2020/3/20 15:05
	 * @Param [reqParam]
	 * @Return org.springframework.web.context.request.async.DeferredResult<cn.com.bosssoft.gpmscloud.openapi.controller.common.RespResult>
	 */
	public DeferredResult<RespEntity> newDeferredResult(ReqEntity reqParam) {
		DeferredResult<RespEntity> deferredResult = new DeferredResult<>(60000L);
		startAsyncTask(reqParam, deferredResult);
		return deferredResult;
	}

	/**
	 * 开始异步任务
	 *
	 * @param reqParam
	 * @param deferredResult
	 */
	private void startAsyncTask(ReqEntity reqParam, DeferredResult<RespEntity> deferredResult) {
		String requestId = genRequestId(reqParam);
		reqParam.setRequestId(requestId);
		reqParam.setAppInstanceId(appInstanceId);
		DeferredResultHolder.put(requestId, deferredResult);
		//发送请求（不直接使用结果）
		sendRequest(reqParam);
	}

	/**
	 * @Description 发送请求
	 * @Author lwh
	 * @CreatedAt 2020/3/23 20:28
	 * @UpdatedAt 2020/3/23 20:28
	 * @Param [reqEntity]
	 * @Return com.github.wendao76.model.RespEntity
	 */
	public RespEntity sendRequest(ReqEntity reqEntity) {
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
		return null;
	}


	/**
	 * @Description 根据请求参数生成请求ID
	 * @Author lwh
	 * @CreatedAt 2020/3/20 14:59
	 * @UpdatedAt 2020/3/20 14:59
	 * @Param [reqParam]
	 * @Return java.lang.String
	 */
	private String genRequestId(ReqEntity reqParam) {
		return DigestUtil.md5Hex(JSONUtil.toJsonStr(reqParam));
	}
}
