package com.demo.elastic.job;

import com.alibaba.dubbo.config.annotation.Reference;
import com.dangdang.ddframe.job.api.ShardingContext;
import com.dangdang.ddframe.job.api.simple.SimpleJob;
import com.demo.entity.User;
import com.demo.facade.IUserFacade;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 继承SimpleJob重写execute方法，可在该方法中调用具体的业务逻辑执行批处理任务；
 * ShardingContext参数中包含局的分片信息，具体含义在打印信息中可见，也可参考官方文档；
 * shardingContext.getShardingItem()参数可结合数据库的分区来是实现分区操作；
 */
@Service
public class MyElasticJob implements SimpleJob {
    private static final Logger logger = LoggerFactory.getLogger(MyElasticJob.class);

    @Reference
    IUserFacade userFacade;

    @Override
    public void execute(ShardingContext shardingContext) {
        logger.debug("------ start MyElasticJob ------");
        List<User> users = userFacade.list();
        logger.debug("The total of user is "+ users.size());
        logger.debug(String.format("------数据插入完成，Thread ID: %s, 任务总片数: %s, " +
                        "当前分片项: %s.当前参数: %s," +
                        "当前任务名称: %s.当前任务参数: %s",
                Thread.currentThread().getId(),
                shardingContext.getShardingTotalCount(),
                shardingContext.getShardingItem(),
                shardingContext.getShardingParameter(),
                shardingContext.getJobName(),
                shardingContext.getJobParameter()

        ));
        logger.debug("------ finish MyElasticJob ------");
    }
}