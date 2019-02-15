package com.demo.facade;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.demo.entity.User;
import com.demo.util.query.PageCondition;

import java.util.List;

public interface IUserFacade {
    User get(Long id);

    List<User> selectAll();

    void save(User user);

    void removeById(Long id);

    void updateById(User user);

    User getById(Long id);

    List<User> list();

    IPage<User> getPage(User user, PageCondition condition);
}
