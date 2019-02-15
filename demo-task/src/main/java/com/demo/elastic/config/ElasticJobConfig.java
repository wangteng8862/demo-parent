package com.demo.elastic.config;


import com.alibaba.druid.pool.DruidDataSource;
import com.dangdang.ddframe.job.api.simple.SimpleJob;
import com.dangdang.ddframe.job.config.JobCoreConfiguration;
import com.dangdang.ddframe.job.config.simple.SimpleJobConfiguration;
import com.dangdang.ddframe.job.event.JobEventConfiguration;
import com.dangdang.ddframe.job.event.rdb.JobEventRdbConfiguration;
import com.dangdang.ddframe.job.lite.api.JobScheduler;
import com.dangdang.ddframe.job.lite.config.LiteJobConfiguration;
import com.dangdang.ddframe.job.lite.spring.api.SpringJobScheduler;
import com.dangdang.ddframe.job.reg.zookeeper.ZookeeperRegistryCenter;
import com.demo.elastic.job.MyElasticJob;
import com.demo.elastic.listener.ElasticJobListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;

/**
 * job配置管理类
 **/
@Configuration
public class ElasticJobConfig {

    @Autowired
    private ZookeeperRegistryCenter regCenter;

    @Resource
    MyElasticJob myElasticJob;

    @Resource
    private DruidDataSource dataSource;


    /**
     * 初始化job，如有多个job，就另外初始化多个Bean
     *
     * @param cron
     * @param shardingTotalCount
     * @param shardingItemParameters
     * @return
     */
    @Bean(initMethod = "init")
    public JobScheduler simpleJobScheduler(@Value("${stockJob.cron}") final String cron, @Value("${stockJob.shardingTotalCount}") final int shardingTotalCount, @Value("${stockJob.shardingItemParameters}") final String shardingItemParameters) {
        return new SpringJobScheduler(myElasticJob, regCenter, getLiteJobConfiguration(myElasticJob.getClass(), cron, shardingTotalCount, shardingItemParameters), jobEventConfiguration(), elasticJobListener());
    }

    /**
     * 将作业运行的痕迹（日志信息）进行持久化到DB，可在console控制台中查看
     *
     * @return
     */
    @Bean
    public JobEventConfiguration jobEventConfiguration() {
        return new JobEventRdbConfiguration(dataSource);
    }

    /**
     * 初始化监听器，用于监听job的结束和开始
     *
     * @return
     */
    @Bean
    public ElasticJobListener elasticJobListener() {
        return new ElasticJobListener(5000L, 10000L);
//        return new SimpleJobListener();
    }


    /**
     * @Description 任务配置类
     * 如有详细配置，可使用JobCoreConfiguration另外的构造器，这里选取了必要的配置
     */
    private LiteJobConfiguration getLiteJobConfiguration(final Class<? extends SimpleJob> jobClass,
                                                         final String cron,
                                                         final int shardingTotalCount,
                                                         final String shardingItemParameters) {


        return LiteJobConfiguration
                .newBuilder(
                        new SimpleJobConfiguration(
                                JobCoreConfiguration.newBuilder(
                                        jobClass.getName(), cron, shardingTotalCount)
                                        .shardingItemParameters(shardingItemParameters)
                                        .build()
                                , jobClass.getCanonicalName()
                        )
                )
                .overwrite(true)
                .build();

    }
}