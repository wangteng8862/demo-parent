package com.demo.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * Author: wt
 * Date: 2019/2/11
 * Describe:
 */
@Data
@TableName("user")
@ApiModel(value = "用户实体", description = "这是用户对象")
public class User implements Serializable{

    @ApiModelProperty(value = "id", example = "id", required = false)
    @TableId(value = "id")
    private Long id;

    /**
     * TableField 的value可为空，驼峰命名方式自动识别
     */
    @ApiModelProperty(value = "姓名", example = "姓名", required = true)
    @TableField(value = "name")
    private String name;

    @ApiModelProperty(value = "性别", example = "性别", required = true)
    @TableField("sex")
    private Integer sex;

    @ApiModelProperty(value = "年龄", example = "年龄", required = true)
    @TableField("age")
    private Integer age;

    /**
     * 使用数据库时间,输出 SQL 为：update 表 set 字段=now() where ...
     */
    @ApiModelProperty(hidden = true)
    @TableField(value = "modifyTime", update = "now()")
    private String modifyTime;

    /**
     * 表示类中有的属性，而对应的属性在表中没有这样的一个字段,不映射
     */
    @ApiModelProperty(hidden = true)
    @TableField(exist = false)
    private String testField;
}
