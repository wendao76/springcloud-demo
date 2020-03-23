package com.github.wendao76.component.mq;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @Description 自定义mq属性
 * @ClassName CustomMqPropertity
 * @Author lwh
 * @Date 2020/3/23 19:31
 * @Version 1.0
 */
@ConfigurationProperties("custom-mq")
@Component
@Data
public class CustomMqProperty {
	private String exchangeName;

	private String queueNamePre;

	private String defaultRouteKey;
}
