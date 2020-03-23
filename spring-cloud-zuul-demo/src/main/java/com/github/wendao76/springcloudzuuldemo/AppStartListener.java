package com.github.wendao76.springcloudzuuldemo;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

/**
 * @Description 类描述信息
 * @ClassName AppStartListener
 * @Author tiger
 * @Date 2020/3/23 17:00
 * @Version 1.0
 */
public class AppStartListener implements ApplicationListener<ContextRefreshedEvent> {
	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		System.out.println("ContextRefreshedEvent");
	}
}
