package com.demo.controller.annotation;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.lang.annotation.*;

/**
 * Author: wt
 * Date: 2019/2/12
 * Describe: 条件查询所有数据方法RequestMapping注解
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@RequestMapping(value = "/selectAll", method = RequestMethod.GET)
public @interface SelectAllUrl {
}
