package com.demo.util.query;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * Author: wt
 * Time: 2019/2/12
 * Describe:
 */
@Data
@ApiModel
public class PageCondition {

    @ApiModelProperty(value = "页数", example = "pageNum", required = true)
    private int pageNum = 0;

    @ApiModelProperty(value = "每页数量", example = "pageSize", required = true)
    private int pageSize = 15;

    @ApiModelProperty(value = "排序字段", example = "order", required = false)
    private String order;

    @ApiModelProperty(value = "排序规则", example = "排序规则 默认降序，升序=ASC", required = false)
    private String orderBy = "DESC";
}
