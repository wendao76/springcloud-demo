package com.github.wendao76.springcloud.component;

import org.springframework.cloud.netflix.zuul.filters.post.SendErrorFilter;

/**
 * @Description 类描述信息
 * @ClassName ZuulExceptionResolver
 * @Author tiger
 * @Date 2020/3/24 10:02
 * @Version 1.0
 */
public class ZuulExceptionResolver extends SendErrorFilter {
	@Override
	public Object run() {
		System.out.println("ZuulExceptionResolver.run");
		return super.run();
	}
}
