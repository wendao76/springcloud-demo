#WebFlux+websocket样例
```$xslt
#依赖
<!-- https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-starter-webflux -->
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-webflux</artifactId>
    <version>2.2.5.RELEASE</version>
</dependency>
```
> webflux本身支持websocket 
> 需要使用netty内核， 否则会出现握手不成功的情况 