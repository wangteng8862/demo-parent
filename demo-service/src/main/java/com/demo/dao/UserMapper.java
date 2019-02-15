package com.demo.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.demo.entity.User;

/**
 * Author: wt
 * Date: 2019/2/11
 * Describe: 一般写自定义sql才会用到，其他常用的crud在Impl里面可以直接调用IService的方法。
 */
public interface UserMapper extends BaseMapper<User> {

}
