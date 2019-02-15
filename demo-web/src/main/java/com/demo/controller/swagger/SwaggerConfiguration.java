package com.demo.controller.swagger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Author: wt
 * Date: 2019/2/11
 * Describe: Swagger接口文档配置类
 */
@Configuration
@EnableSwagger2
public class SwaggerConfiguration {

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.demo.controller"))//扫描的接口路径
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        //http://localhost:8080/swagger-ui.html
        return new ApiInfoBuilder()
                //页面标题
                .title("平台组demo接口文档")
                //联系人
                .contact(new Contact("", "http://www.geekplus.com.cn/", "wangteng@geekplus.com.cn"))
                //版本号
                .version("1.0")
                //描述
                .description("API 描述")
                .build();
    }

    /*
    swagger通过注解表明该接口会生成文档，包括接口名、请求方法、参数、返回信息的等等。
    @Api：修饰整个类，描述Controller的作用
    @ApiOperation：描述一个类的一个方法，或者说一个接口
    @ApiParam：单个参数描述
    @ApiModel：用对象来接收参数
    @ApiProperty：用对象接收参数时，描述对象的一个字段
    @ApiResponse：HTTP响应其中1个描述
    @ApiResponses：HTTP响应整体描述
    @ApiIgnore：使用该注解忽略这个API
    @ApiError ：发生错误返回的信息
    @ApiImplicitParam：一个请求参数
    @ApiImplicitParams：多个请求参数

    在使用swagger的时候可能会遇到的bug，当前后端的传递参数的名称对应上之后，后台仍然无法接收到参数，
    这可能是因为我们没有加上request相关的说明，如@requestParam @requestBody  required=true 等。这样会导致 
    从swagger.ui.html中传递过来的参数后台无法接收到。但是在正常的开发过程中我们是即使不写这几个request相关的注解，
    只要属性的名字可能对应上，那么后台也是可能正常接受到参数的。这也许是swagger2中隐藏的一个bug。
    * */
}
