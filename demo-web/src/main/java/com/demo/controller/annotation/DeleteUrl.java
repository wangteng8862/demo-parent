package com.demo.controller.annotation;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.lang.annotation.*;

/**
 * Author: wt
 * Date: 2019/2/11
 * Describe: 单条删除方法RequestMapping注解
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@RequestMapping(value = "/delete", method = RequestMethod.GET)
public @interface DeleteUrl {
}
