#Zuul服务网关样例
##注册到eureka服务发现服务  
##加入actuator监控
 * 添加actuator依赖
```$xslt
<dependency>
   <groupId>org.springframework.boot</groupId>
   <artifactId>spring-boot-starter-actuator</artifactId>
   <version>2.2.0.RELEASE</version>
</dependency>
```
 * 加入过滤器
 
> 继承ZuulFilter  
> Bean方式注入
 * 配置异步请求支持
> 创建TaskExecutor 任务池
> 配置 configureAsyncSupport 方法加入任务池