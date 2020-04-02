package com.github.wendao76.springcloud.component;

import com.github.wendao76.springcloud.config.annotation.RequestEntity;
import com.github.wendao76.springcloud.model.ReqEntity;
import org.springframework.core.MethodParameter;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

/**
 * @Description 类描述信息
 * @ClassName ReqEntityArgumentResolver
 * @Author tiger
 * @Date 2020/3/23 11:22
 * @Version 1.0
 */
public class ReqEntityArgumentResolver implements HandlerMethodArgumentResolver {
	@Override
	public boolean supportsParameter(MethodParameter parameter) {
		return parameter.hasParameterAnnotation(RequestEntity.class);
	}

	@Override
	public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer, NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
		//TODO 请求参数统一封装
		ReqEntity reqEntity = new ReqEntity();
		reqEntity.setUrl("http://localhost:8080/v1/hello?name=123");
		reqEntity.setRequestMethod(RequestMethod.GET);
		return reqEntity;
	}
}
