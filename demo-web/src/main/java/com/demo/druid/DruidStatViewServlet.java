package com.demo.druid;

import com.alibaba.druid.spring.boot.autoconfigure.properties.DruidStatProperties;

import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;

/**
 * Author: wt
 * Date: 2019/2/12
 * Describe: StatViewServlet  展示Druid的统计信息。
 */
@SuppressWarnings("serial")
@WebServlet(urlPatterns = "/druid/*",
        initParams={
                @WebInitParam(name="allow",value=""),// IP白名单 (没有配置或者为空，则允许所有访问)
                @WebInitParam(name="deny",value=""),// IP黑名单 deny优先于allow，如果在deny列表中，就算在allow列表中，也会被拒绝。
                @WebInitParam(name="loginUsername",value="admin"),// 监控页面访问的用户名
                @WebInitParam(name="loginPassword",value="123456"),// 监控页面访问的密码
                @WebInitParam(name="resetEnable",value="false")// 禁用HTML页面上的“Reset All”功能
        })
public class DruidStatViewServlet extends DruidStatProperties.StatViewServlet {
}
