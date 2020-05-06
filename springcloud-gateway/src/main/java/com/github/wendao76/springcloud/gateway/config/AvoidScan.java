package com.github.wendao76.springcloud.gateway.config;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Description 类描述信息
 * @ClassName AvoidScan
 * @Author wendao76
 * @Date 2020-4-16 19:46
 * @Version 1.0
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface AvoidScan {
}
