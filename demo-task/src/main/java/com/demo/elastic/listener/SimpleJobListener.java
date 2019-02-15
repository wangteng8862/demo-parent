package com.demo.elastic.listener;

import com.dangdang.ddframe.job.executor.ShardingContexts;
import com.dangdang.ddframe.job.lite.api.listener.ElasticJobListener;

/**
 * 暂时不知道干什么用
 */
public class SimpleJobListener implements ElasticJobListener{

    public SimpleJobListener() {
    }

    @Override
    public void beforeJobExecuted(ShardingContexts shardingContexts) {
        System.out.println("----------------------------------------------->>>>>>>>>>>>>>>>>");
    }

    @Override
    public void afterJobExecuted(ShardingContexts shardingContexts) {
        System.out.println("<<<<<<<<<<<<<<<-------------------------------------------------");
    }
}
