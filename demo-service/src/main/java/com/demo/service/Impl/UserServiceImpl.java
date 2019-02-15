package com.demo.service.Impl;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.demo.dao.UserMapper;
import com.demo.entity.User;
import com.demo.service.IUserService;
import com.demo.util.query.PageCondition;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;


/**
 * Author: wt
 * Date: 2019/2/11
 * Describe:
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

    @Override
    public IPage<User> getPage(User user, PageCondition condition) {
        IPage<User> page = page(new Page<User>(condition.getPageNum(), condition.getPageSize()), new QueryWrapper<User>().like(StringUtils.isNoneBlank(user.getName()), "name", user.getName()));
        return page;
    }
}
