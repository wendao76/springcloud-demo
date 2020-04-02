package com.github.wendao76.springcloud.component;

import org.springframework.cloud.netflix.zuul.filters.SimpleRouteLocator;
import org.springframework.cloud.netflix.zuul.filters.ZuulProperties;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @Description 路由重构器-目前仅用于生成短路径映射
 * @ClassName GlobalRouteLocator
 * @Author tiger
 * @Date 2020/3/22 9:09
 * @Version 1.0
 */
public class GlobalRouteLocator extends SimpleRouteLocator {
	/**
	 * 映射服务短路径映射
	 */
	public static Map<String, ZuulProperties.ZuulRoute> shortRouteMap = new LinkedHashMap<>();

	public GlobalRouteLocator(String servletPath, ZuulProperties properties) {
		super(servletPath, properties);
		generateShortRouteMap();
	}

	/**
	 * @Description generateShortRouteMap
	 * @Author lwh
	 * @CreatedAt 2020/3/23 20:53
	 * @UpdatedAt 2020/3/23 20:53
	 * @Param []
	 * @Return void
	 */
	private void generateShortRouteMap() {
		Map<String, ZuulProperties.ZuulRoute> zuulRouteMap = super.getRoutesMap();
		for (Map.Entry<String, ZuulProperties.ZuulRoute> entry : zuulRouteMap.entrySet()) {
			String path = entry.getValue().getPath();
			String shortPath = path.substring(1, path.lastIndexOf("/"));
			shortRouteMap.put(shortPath, zuulRouteMap.get(entry.getKey()));
		}
	}
}
