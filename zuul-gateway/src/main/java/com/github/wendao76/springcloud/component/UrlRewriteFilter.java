package com.github.wendao76.springcloud.component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;

/**
 * @Description 路由重写过滤器(仅zuul根路由或者带转发路由经过)
 * @ClassName UrlRewriteFilter
 * @Author tiger
 * @Date 2020/3/22 16:20
 * @Version 1.0
 */
public class UrlRewriteFilter extends ZuulFilter {
	@Override
	public String filterType() {
		return FilterConstants.PRE_TYPE;
	}

	@Override
	public int filterOrder() {
		//执行顺序晚于自带filter
		return FilterConstants.PRE_DECORATION_FILTER_ORDER + 2;
	}

	@Override
	public boolean shouldFilter() {
		return true;
	}

	@Override
	public Object run() throws ZuulException {
		System.out.println("UrlRewriteFilter.run");
		//TODO 可选
//		RequestContext context = RequestContext.getCurrentContext();
//		HttpServletRequest request = context.getRequest();
//		String method = request.getParameter("method");
//		if (method == null) {
//			return null;
//		}
//		String[] routeArray = StrUtil.split(method, ".");
//		RouteModel routeModel = OpenApiUtils.getRouteModel(context.getRequest());
//		String modifiedRequestPath = routeModel.getUri();
//
//		context.set(FilterConstants.REQUEST_URI_KEY, modifiedRequestPath);
//		if (GlobalRouteLocator.shortRouteMap.containsKey(routeArray[0])) {
//			ZuulProperties.ZuulRoute zuulRoute = GlobalRouteLocator.shortRouteMap.get(routeArray[0]);
//			context.set(FilterConstants.SERVICE_ID_KEY, zuulRoute.getServiceId());
//			context.set(FilterConstants.PROXY_KEY, zuulRoute.getServiceId());
//			context.set(FilterConstants.REQUEST_URI_KEY, modifiedRequestPath);
//			context.set(FilterConstants.IS_DISPATCHER_SERVLET_REQUEST_KEY, true);
//			context.set(FilterConstants.RETRYABLE_KEY, false);
//			context.remove(FilterConstants.FORWARD_TO_KEY);
//		}
		return null;
	}
}
