package com.github.wendao76.model;

import lombok.Data;

import java.io.Serializable;

/**
 * @Description 返回数据对象
 * @ClassName RespEntity
 * @Author tiger
 * @Date 2020/3/23 10:58
 * @Version 1.0
 */
@Data
public class RespEntity implements Serializable {
	private String msg = "";
	private Integer code = 0;
	private Object data;

	public RespEntity(Object data) {
		this.data = data;
	}

	public RespEntity() {
	}
}
