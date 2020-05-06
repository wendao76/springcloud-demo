package com.github.wendao76.springcloud.gateway.config;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.AbstractLoadBalancerRule;
import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.Server;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

/**
 * 消息服务路由（WebSocket)
 * <p>
 * websocket必须使用一致路由规则
 * </p>
 *
 * @Description 消息服务路由
 * @ClassName WsLoadBalanceRule
 * @Author wendao76
 * @Date 2020-4-3 11:03
 * @Version 1.0
 */
@Slf4j
public class MyBalanceRule extends AbstractLoadBalancerRule {

	@Override
	public void initWithNiwsConfig(IClientConfig iClientConfig) {
		log.info("CustomBalanceRule.initWithNiwsConfig");
	}

	@Override
	public Server choose(Object key) {
		ILoadBalancer lb = getLoadBalancer();
		List<Server> serverList = lb.getAllServers();
		return serverList.get(0);
	}
}
