package com.github.wendao76.component;

import cn.hutool.core.util.StrUtil;
import com.github.wendao76.model.RespEntity;
import org.springframework.web.context.request.async.DeferredResult;

/**
 * @Description 异步任务处理
 * @ClassName AsyncTaskHandler
 * @Author tiger
 * @Date 2020/3/20 11:02
 * @Version 1.0
 */
public class AsyncTaskHandler implements Runnable {
	private RespEntity respEntity;

	public AsyncTaskHandler(RespEntity respEntity) {
		this.respEntity = respEntity;
	}

	@Override
	public void run() {
		if (StrUtil.isEmpty(respEntity.getRequestId())) {
			return;
		}
		DeferredResult<RespEntity> respEntityDeferredResult = DeferredResultHolder.get(respEntity.getRequestId());

		System.out.println("AsyncTaskHandler.run");
		//结果设置， 唤醒挂起的请求
		respEntityDeferredResult.setResult(respEntity);
	}
}
