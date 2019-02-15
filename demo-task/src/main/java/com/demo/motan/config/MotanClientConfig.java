package com.demo.motan.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.weibo.api.motan.config.springsupport.BasicRefererConfigBean;

/**
 * @Description: motan client配置
 */
@Configuration
public class MotanClientConfig
{
    /**
     * @Description: 客户端配置
     */
    @Bean(name = "demoMotanClientConfig")
    @ConfigurationProperties(prefix = "motan.client")
    public BasicRefererConfigBean baseRefererConfig() {
        BasicRefererConfigBean config = new BasicRefererConfigBean();
        return config;
    }
}
