package com.github.wendao76.assembly;

import com.github.wendao76.eurekaserverdemo.EurekaServerDemoApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.context.scope.refresh.RefreshScope;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @author wendao76
 */
@SpringBootApplication
public class WendaoCloudApplication {
    public static void main(String[] args) {
        ConfigurableApplicationContext commonContext =
                new SpringApplicationBuilder(WendaoCloudApplication.class).web(WebApplicationType.NONE).run(new String[0]);

        //开启两个注册中心
        new SpringApplicationBuilder(EurekaServerDemoApplication.class)
                .parent(commonContext).sources(RefreshScope.class).run(new String[]{args[0]});

        new SpringApplicationBuilder(EurekaServerDemoApplication.class)
                .parent(commonContext).sources(RefreshScope.class).run(new String[]{args[1]});
    }
}
