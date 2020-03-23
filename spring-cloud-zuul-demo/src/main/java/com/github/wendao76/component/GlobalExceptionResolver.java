package com.github.wendao76.component;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Description 类描述信息
 * @ClassName GlobalExceptionResolver
 * @Author tiger
 * @Date 2020/3/24 9:56
 * @Version 1.0
 */
public class GlobalExceptionResolver implements HandlerExceptionResolver {
	@Override
	public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
		System.out.println("GlobalExceptionResolver");
		return null;
	}
}
