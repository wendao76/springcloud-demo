package com.github.wendao76.springcloud.util;

import cn.hutool.core.util.ArrayUtil;
import cn.hutool.core.util.StrUtil;
import com.github.wendao76.springcloud.component.RouteModel;
import org.springframework.cloud.netflix.zuul.filters.ZuulProperties;

import javax.servlet.http.HttpServletRequest;

/**
 * @Description api工具
 * @ClassName OpenApiUtils
 * @Author lwh
 * @Date 2020/3/22 9:15
 * @Version 1.0
 */
public class OpenApiUtils {
	public static RouteModel getRouteModel(HttpServletRequest request) {
		if (request == null) {
			return null;
		}
		String version = request.getParameter("version");
		version = StrUtil.isNotBlank(version) ? version : "v1";

		String method = request.getParameter("method");
		String[] routeArray = StrUtil.split(method, ".");
		String[] uriArray = ArrayUtil.sub(routeArray, 1, routeArray.length);

		RouteModel routeModel = new RouteModel();
		routeModel.setShortServiceId(routeArray[0]);
		routeModel.setUri("/" + version + "/" + ArrayUtil.join(uriArray, "/"));
		return routeModel;
	}

	public static ZuulProperties.ZuulRoute getRoute(HttpServletRequest request) {
		String[] routeArr = StrUtil.split(request.getParameter("method"), ".");
		String version = request.getParameter("version");
		String[] uriArray = ArrayUtil.sub(routeArr, 1, routeArr.length);

		ZuulProperties.ZuulRoute zuulRoute = new ZuulProperties.ZuulRoute();
		zuulRoute.setId(routeArr[0]);
		zuulRoute.setPath("/" + routeArr[0] + "/**");
		zuulRoute.setServiceId(routeArr[0]);
		zuulRoute.setStripPrefix(true);
		zuulRoute.setUrl("/" + routeArr[0] + "/" + version + "/" + ArrayUtil.join(uriArray, "/"));
		return zuulRoute;
	}
}
