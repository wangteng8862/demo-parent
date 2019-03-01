package com.demo.facade.impl;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.demo.entity.User;
import com.demo.facade.IUserFacade;
import com.demo.service.IUserService;
import com.demo.util.query.PageCondition;
import com.weibo.api.motan.config.springsupport.annotation.MotanService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@MotanService
public class UserFacadeImpl implements IUserFacade {
    @Autowired
    private IUserService userService;

    @Override
    public User get(Long id) {
        return userService.getById(id);
    }

    @Override
    public List<User> selectAll() {
        return userService.list();
    }

    @Override
    public void save(User user) {
        userService.mySave(user);
    }

    @Override
    public void removeById(Long id) {
        userService.removeById(id);
    }

    @Override
    public void updateById(User user) {
        userService.updateById(user);
    }

    @Override
    public User getById(Long id) {
        return userService.getById(id);
    }

    @Override
    public List<User> list() {
        return userService.list();
    }

    @Override
    public IPage<User> getPage(User user, PageCondition condition) {
        return userService.getPage(user, condition);
    }
}
