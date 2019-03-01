package com.demo.motan.config;

import com.weibo.api.motan.config.springsupport.BasicServiceConfigBean;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Description: motan server配置
 */
@Configuration
public class MotanServerConfig {
    /**
     * @Description: 服务端配置
     */
    @Bean
    @ConfigurationProperties(prefix = "motan.server")
    public BasicServiceConfigBean baseServiceConfig() {
        BasicServiceConfigBean config = new BasicServiceConfigBean();
        return config;
    }
}
