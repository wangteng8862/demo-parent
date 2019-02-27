package com.demo.xxl.job;

import com.alibaba.dubbo.config.annotation.Reference;
import com.demo.entity.User;
import com.demo.facade.IUserFacade;
import com.xxl.job.core.biz.model.ReturnT;
import com.xxl.job.core.handler.IJobHandler;
import com.xxl.job.core.handler.annotation.JobHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by wangteng on 2019/2/20.
 */
@JobHandler(value = "demoJob")
@Component
public class DemoJobHandler extends IJobHandler {
    private static final Logger logger = LoggerFactory.getLogger(DemoJobHandler.class);

    @Reference
    IUserFacade userFacade;

    @Override
    public ReturnT<String> execute(String param) throws Exception {
        logger.debug("------ start DemoJobHandler ------");
        List<User> users = userFacade.list();
        logger.debug("The total of user is "+ users.size());
        logger.debug("------ finish DemoJobHandler ------");
        return SUCCESS;
    }
}
