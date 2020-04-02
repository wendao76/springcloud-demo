package com.github.wendao76.springcloud.zuuldemo;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextClosedEvent;

/**
 * @Description 类描述信息
 * @ClassName AppStartListener
 * @Author tiger
 * @Date 2020/3/23 17:00
 * @Version 1.0
 */
public class AppStopListener implements ApplicationListener<ContextClosedEvent> {
	@Override
	public void onApplicationEvent(ContextClosedEvent event) {
		System.out.println("ContextClosedEvent");
	}
}
