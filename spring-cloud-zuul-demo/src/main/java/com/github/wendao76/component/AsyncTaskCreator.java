package com.github.wendao76.component;

import com.github.wendao76.model.ReqEntity;
import com.github.wendao76.model.RespEntity;
import org.springframework.web.context.request.async.DeferredResult;

import java.util.concurrent.Callable;

/**
 * @Description 异步任务请求工厂
 * @ClassName AsyncCallerTaskFactory
 * @Author tiger
 * @Date 2020/3/20 11:02
 * @Version 1.0
 */
public class AsyncTaskCreator {
	static DeferredResultHolder deferredResultHolder = new DeferredResultHolder();

	/**
	 * @Description Callable 方式异步请求
	 * @Author lwh
	 * @CreatedAt 2020/3/20 16:20
	 * @UpdatedAt 2020/3/20 16:20
	 * @Param [reqParam]
	 * @Return java.util.concurrent.Callable<cn.com.bosssoft.gpmscloud.openapi.controller.common.RespResult>
	 */
	public static Callable<RespEntity> newCallable(ReqEntity reqParam) {
		return new Callable<RespEntity>() {
			@Override
			public RespEntity call() throws Exception {
				// TODO 同步请求处理
				return new RespEntity();
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
	public static DeferredResult<RespEntity> newDeferredResult(ReqEntity reqParam) {
		DeferredResult<RespEntity> deferredResult = new DeferredResult<>(60000L);
		String requestId = genRequestId(reqParam);
		reqParam.setRequestId(requestId);
		//------------调用模拟----------------------------------------------------------------------------------
		new Thread(() -> {
			try {
				Thread.sleep(6000);
				DeferredResult<RespEntity> dfResult = deferredResultHolder.getMap().get(genRequestId(reqParam));
				RespEntity respResult = new RespEntity("这个是异步处理结果");
				//设置结果，唤起处理显出， 返回给用户
				dfResult.setResult(respResult);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}).start();
		//------------------------------------------------------------------------------------------------------
		startAsyncTask(reqParam, deferredResult);
		return deferredResult;
	}

	static void startAsyncTask(ReqEntity reqParam, DeferredResult<RespEntity> deferredResult) {
		//TODO 本地处理 + 服务异步调用
		startMQListening(reqParam.getRequestId());
		deferredResultHolder.getMap().put(reqParam.getRequestId(), deferredResult);
	}

	static void startMQListening(String requestId) {
		//TODO 开启MQ监听
	}

	/**
	 * @Description 根据请求参数生成请求ID
	 * @Author lwh
	 * @CreatedAt 2020/3/20 14:59
	 * @UpdatedAt 2020/3/20 14:59
	 * @Param [reqParam]
	 * @Return java.lang.String
	 */
	private static String genRequestId(ReqEntity reqParam) {
		return "12345678";
	}
}
