package com.demo.motan.config;

import com.weibo.api.motan.config.springsupport.AnnotationBean;
import com.weibo.api.motan.config.springsupport.ProtocolConfigBean;
import com.weibo.api.motan.config.springsupport.RegistryConfigBean;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Description: motan通用配置
 */
@Configuration
public class MotanConfig
{
    /**
     * @Description: 声明Annotation用来指定需要解析的包名
     */
    @Bean
    @ConfigurationProperties(prefix = "motan.annotation")
    public AnnotationBean motanAnnotationBean() {
        AnnotationBean motanAnnotationBean = new AnnotationBean();
        return motanAnnotationBean;
    }
    
    /**
     * @Description: 协议配置
     */
    @Bean(name = "demoMotan")
    @ConfigurationProperties(prefix = "motan.protocol")
    public ProtocolConfigBean protocolConfig() {
        ProtocolConfigBean config = new ProtocolConfigBean();
        return config;
    }

    /**
     * @Description: 注册中心配置
     */
    @Bean(name = "demoRegistryConfig")
    @ConfigurationProperties(prefix = "motan.registry")
    public RegistryConfigBean registryConfig() {
        RegistryConfigBean config = new RegistryConfigBean();
        return config;
    }
}
