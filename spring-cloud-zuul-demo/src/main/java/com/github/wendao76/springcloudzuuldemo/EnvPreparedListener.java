package com.github.wendao76.springcloudzuuldemo;

import org.springframework.boot.context.event.ApplicationEnvironmentPreparedEvent;
import org.springframework.context.ApplicationListener;

import java.util.Map;
import java.util.UUID;

/**
 * @Description 添加全局动态环境变量
 * @ClassName EnvPreparedListener
 * @Author lwh
 * @Date 2020/3/23 17:54
 * @Version 1.0
 */
public class EnvPreparedListener implements ApplicationListener<ApplicationEnvironmentPreparedEvent> {
	@Override
	public void onApplicationEvent(ApplicationEnvironmentPreparedEvent event) {
		Map<String, Object> env = event.getEnvironment().getSystemProperties();
		//生成appId
		env.put("appInstanceId", UUID.randomUUID().toString().replace("-", ""));
		System.out.println("ApplicationEnvironmentPreparedEvent");
	}
}
