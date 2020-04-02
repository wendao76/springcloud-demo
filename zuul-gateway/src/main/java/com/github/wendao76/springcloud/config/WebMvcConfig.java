package com.github.wendao76.springcloud.config;

import com.github.wendao76.springcloud.component.GlobalExceptionResolver;
import com.github.wendao76.springcloud.component.ReqEntityArgumentResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.config.annotation.AsyncSupportConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import java.util.List;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @Description 类描述信息
 * @ClassName WebMvcConfig
 * @Author tiger
 * @Date 2020/3/23 11:21
 * @Version 1.0
 */
@Configuration
public class WebMvcConfig extends WebMvcConfigurationSupport {
	@Override
	public void addArgumentResolvers(List<HandlerMethodArgumentResolver> resolvers) {
		resolvers.add(new ReqEntityArgumentResolver());
	}

	@Override
	protected void configureAsyncSupport(AsyncSupportConfigurer configurer) {
		configurer.setTaskExecutor(getAsyncThreadPoolTaskExecutor());
		super.configureAsyncSupport(configurer);
	}

	@Override
	protected void extendHandlerExceptionResolvers(List<HandlerExceptionResolver> exceptionResolvers) {
		exceptionResolvers.add(new GlobalExceptionResolver());
		super.extendHandlerExceptionResolvers(exceptionResolvers);
	}

	@Bean(name = "asyncPoolTaskExecutor")
	public ThreadPoolTaskExecutor getAsyncThreadPoolTaskExecutor() {
		ThreadPoolTaskExecutor taskExecutor = new ThreadPoolTaskExecutor();
		taskExecutor.setCorePoolSize(20);
		taskExecutor.setMaxPoolSize(200);
		taskExecutor.setQueueCapacity(25);
		taskExecutor.setKeepAliveSeconds(200);
		taskExecutor.setThreadNamePrefix("callable-");
		// 线程池对拒绝任务（无线程可用）的处理策略，目前只支持AbortPolicy、CallerRunsPolicy；默认为后者
		taskExecutor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
		taskExecutor.initialize();
		return taskExecutor;
	}

	@Bean(name = "deferredResultPoolTaskExecutor")
	public ThreadPoolTaskExecutor deferredResultThreadPoolTaskExecutor() {
		ThreadPoolTaskExecutor taskExecutor = new ThreadPoolTaskExecutor();
		taskExecutor.setCorePoolSize(20);
		taskExecutor.setMaxPoolSize(200);
		taskExecutor.setQueueCapacity(25);
		taskExecutor.setKeepAliveSeconds(200);
		taskExecutor.setThreadNamePrefix("deferredResult-");
		// 线程池对拒绝任务（无线程可用）的处理策略，目前只支持AbortPolicy、CallerRunsPolicy；默认为后者
		taskExecutor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
		taskExecutor.initialize();
		return taskExecutor;
	}
}
