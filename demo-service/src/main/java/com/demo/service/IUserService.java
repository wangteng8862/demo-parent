package com.demo.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.demo.entity.User;
import com.demo.util.query.PageCondition;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Author: wt
 * Date: 2019/2/11
 * Describe:
 */
public interface IUserService extends IService<User> {

    IPage<User> getPage(User user, PageCondition condition);
}