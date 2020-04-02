package com.github.wendao76.springcloud.config;

import com.github.wendao76.springcloud.component.AuthorizationFilter;
import com.github.wendao76.springcloud.component.GlobalRouteLocator;
import com.github.wendao76.springcloud.component.UrlRewriteFilter;
import com.github.wendao76.springcloud.component.ZuulExceptionResolver;
import com.squareup.okhttp.OkHttpClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.servlet.DispatcherServletPath;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.netflix.zuul.filters.ZuulProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;

/**
 * @Description 自定义网关配置
 * @ClassName ZuulConfig
 * @Author tiger
 * @Date 2020/3/22 9:10
 * @Version 1.0
 */
@Configuration
public class CustomZuulConfig {
	@Resource
	protected ZuulProperties zuulProperties;

	@Autowired
	DiscoveryClient discoveryClient;

	//	@Bean
	public GlobalRouteLocator globalRouteLocator(DispatcherServletPath server) {
		return new GlobalRouteLocator(server.getPrefix(), zuulProperties);
	}

	//	@Bean
	public UrlRewriteFilter urlRewriteFilter() {
		return new UrlRewriteFilter();
	}

	//	@Bean
	public AuthorizationFilter authorizationFilter() {
		return new AuthorizationFilter();
	}

	@Bean
	public OkHttpClient okHttpClient() {
		return new OkHttpClient();
	}

	//	@Bean
	public ZuulExceptionResolver zuulExceptionResolver() {
		return new ZuulExceptionResolver();
	}
}
