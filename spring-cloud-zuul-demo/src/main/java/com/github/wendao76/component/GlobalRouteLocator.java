package com.github.wendao76.component;

import com.netflix.zuul.context.RequestContext;
import org.springframework.cloud.netflix.zuul.filters.Route;
import org.springframework.cloud.netflix.zuul.filters.SimpleRouteLocator;
import org.springframework.cloud.netflix.zuul.filters.ZuulProperties;

import javax.servlet.http.HttpServletRequest;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @Description 路由重构器
 * @ClassName GlobalRouteLocator
 * @Author tiger
 * @Date 2020/3/22 9:09
 * @Version 1.0
 */
public class GlobalRouteLocator extends SimpleRouteLocator {
	public static Map<String, ZuulProperties.ZuulRoute> shortRouteMap = new LinkedHashMap<>();

	public GlobalRouteLocator(String servletPath, ZuulProperties properties) {
		super(servletPath, properties);
	}

	@Override
	public Route getMatchingRoute(String path) {
		return super.getMatchingRoute(path);
	}

	@Override
	protected Map<String, ZuulProperties.ZuulRoute> getRoutesMap() {
		RequestContext requestContext = RequestContext.getCurrentContext();
		HttpServletRequest request = requestContext.getRequest();
		if (request == null) {
			return super.getRoutesMap();
		}

		Map<String, ZuulProperties.ZuulRoute> zuulRouteMap = super.getRoutesMap();
		for (Map.Entry<String, ZuulProperties.ZuulRoute> entry : zuulRouteMap.entrySet()) {
			String path = entry.getValue().getPath();
			String shortPath = path.substring(1, path.lastIndexOf("/"));
			shortRouteMap.put(shortPath, zuulRouteMap.get(entry.getKey()));
		}
		return zuulRouteMap;
	}
}
