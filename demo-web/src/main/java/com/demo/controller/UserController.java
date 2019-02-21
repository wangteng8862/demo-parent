package com.demo.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.demo.controller.annotation.*;
import com.demo.entity.User;
import com.demo.service.IUserService;
import com.demo.util.query.PageCondition;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author wt
 * @Description
 * @Date 2019/2/12 9:36
 **/
@RestController
@RequestMapping("/user")
@Api(tags = "用户业务接口")
public class UserController {
    private static Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private IUserService userService;

    @ApiOperation(value = "新增", notes = "新增用户")
    @AddUrl
    public void save(User user) {
        logger.debug("新增用户");
        userService.save(user);
    }

    @ApiOperation("删除单条")
    @ApiImplicitParam(name = "id", required = true, dataType = "long")
    @DeleteUrl
    public void delete(Long id) {
        logger.debug("删除用户");
        userService.removeById(id);
    }

    @ApiOperation("修改")
    @UpdateUrl
    public void update(User user) {
        logger.debug("修改用户信息");
        userService.updateById(user);
    }

    @ApiOperation("获取单条")
    @ApiImplicitParam(name = "id", required = true, dataType = "long")
    @GetMapping
    public User get(Long id) {
        logger.debug("获取指定用户信息");
        test();
        return userService.getById(id);
    }

    public void test(){
        System.out.println("1111111");
    }

    @ApiOperation("查询所有")
    @SelectAllUrl
    public List<User> selectAll() {
        logger.debug("获取所有用户信息");
        logger.debug("获取所有用户信息222");
        test();
        return userService.list();
    }

    @ApiOperation("分页查询+条件查询")
    @SelectPageUrl
    public IPage<User> selectPage(User user, PageCondition condition) {
        logger.debug("分页查询用户信息");
        return userService.getPage(user, condition);
    }

}
