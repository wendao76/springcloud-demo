package com.github.wendao76.model;

import lombok.Data;
import org.springframework.web.bind.annotation.RequestMethod;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @Description 请求实体
 * @ClassName ReqEntity
 * @Author tiger
 * @Date 2020/3/23 10:53
 * @Version 1.0
 */
@Data
public class ReqEntity implements Serializable {
	private String requestId;
	//请求方法
	private RequestMethod requestMethod;
	private String url;
	private Map<String, Object> data = new LinkedHashMap<>(20);
	private Map<String, String> headers = new LinkedHashMap<>(10);
}
