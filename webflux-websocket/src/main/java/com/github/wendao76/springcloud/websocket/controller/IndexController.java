package com.github.wendao76.springcloud.websocket.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

/**
 * 默认控制器
 *
 * @Description 默认控制器
 * @ClassName IndexController
 * @Author wendao76
 * @Date 2020-4-2 12:32
 * @Version 1.0
 */

@RestController
@RequestMapping("")
public class IndexController {
	@RequestMapping("")
	public Mono<String> index() {
		return Mono.just("Hello World! WEBFLUX-WEBSOCKET");
	}
}
