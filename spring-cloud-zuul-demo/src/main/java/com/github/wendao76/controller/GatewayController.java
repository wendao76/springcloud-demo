package com.github.wendao76.controller;

import com.github.wendao76.component.AsyncTaskCreator;
import com.github.wendao76.config.annotation.RequestEntity;
import com.github.wendao76.model.ReqEntity;
import com.github.wendao76.model.RespEntity;
import com.netflix.appinfo.InstanceInfo;
import com.squareup.okhttp.OkHttpClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.netflix.eureka.EurekaServiceInstance;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
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

	@Autowired
	DiscoveryClient discoveryClient;

	@RequestMapping("/1")
	public Callable<RespEntity> indexAsync(@RequestEntity ReqEntity reqEntity) {
		return asyncTaskCreator.newCallable(reqEntity);
	}

	@RequestMapping("/2")
	public DeferredResult<RespEntity> indexAsync2(@RequestEntity ReqEntity reqEntity) {
		return asyncTaskCreator.newDeferredResult(reqEntity);
	}

	@RequestMapping("/services")
	public String getServiceInfos() {
		Map<String, List<ServiceInstance>> msl = new HashMap<>();
		List<String> services = discoveryClient.getServices();
		for (String service : services) {
			List<ServiceInstance> sis = discoveryClient.getInstances(service);
			msl.put(service, sis);
		}

		EurekaServiceInstance rand = (EurekaServiceInstance) msl.get("microservice-gateway-zuul").get(0);
		InstanceInfo instanceInfo = rand.getInstanceInfo();

		return "ok";
	}
}
