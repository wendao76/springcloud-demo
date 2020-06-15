package com.github.wendao76.springcloud.springcloud.eurekaserver.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wendao76
 * @version 1.0
 * @description 类描述信息
 * @className IndexController
 * @date 2020-6-11 10:35
 */
@RestController
@RequestMapping("/index")
public class IndexController {
	@GetMapping("")
	public String index(@PathVariable String id) {
		System.out.println(id);
		return "Eureka Server is Running";
	}
}
