package com.yoho.springbootdemo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.request.async.DeferredResult;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static com.google.common.base.Predicates.or;
import static springfox.documentation.builders.PathSelectors.regex;

/**
 * Author: Tennyson
 * E-Mail:wangxing@bailefen.com
 * Project:springbootdemo
 * Package:com.yoho.springbootdemo.config
 * DateTime: 2017/12/25  10:29
 * Description:手动添加
 */

@Configuration
/**
 * 开启Swagger2
 * 具体使用查询注释、注解
 */
@EnableSwagger2
public class Swagger2Config {

    @Bean
    public Docket tetsApi(){
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("test")
                .genericModelSubstitutes(DeferredResult.class)
                .useDefaultResponseMessages(false)
                .forCodeGeneration(true)
                //base,最终调用接口会和paths拼接在一起
                .pathMapping("/")
                .select()
                //过滤的接口
                //匹配以 /demo 来头的 mapping 以demo开头，加入Api doc
                .paths(or(regex("/api/.*")))
                .build()
                .apiInfo(testApiInfo());
    }

    @Bean
    public Docket demoApi(){
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("demo")
                .genericModelSubstitutes(DeferredResult.class)
                .useDefaultResponseMessages(false)
                .forCodeGeneration(false)
                .pathMapping("/")
                .select()
                //匹配以 /demo 来头的 mapping 以demo开头，加入Api doc
                .paths(or(regex("/demo/.*")))
                .build()
                .apiInfo(demoApiInfo());
    }

    /**
     * 创建API相关说明文档
     * @return
     */
    private ApiInfo testApiInfo(){
        return  new ApiInfoBuilder()
                //标题
                .title("ApiInfo 测试标题")
                //
                .description("ApiInfo描述")
                .version("1.0")
                //服务URL
                .termsOfServiceUrl("No terms if service")
                //作者相关信息
                .contact(new Contact("测试","URL","wangxing@bailefen.com"))
                //授权
                .license("The Apache License,Version 2")
                //
                .licenseUrl("http://www.apache.org/licenses/LICENSE-2.0.html")
                .build();
    }

    private ApiInfo demoApiInfo() {
        return new ApiInfoBuilder()
                .title("Electronic Health Record(EHR) Platform API")//大标题
                .description("EHR Platform's REST API, all the applications could access the Object model data via JSON.")//详细描述
                .version("1.0")//版本
                .termsOfServiceUrl("NO terms of service")
                .contact(new Contact("测试demo", "测试URL", "wangxing@bailefen.com"))//作者
                .license("The Apache License, Version 2.0")
                .licenseUrl("http://www.apache.org/licenses/LICENSE-2.0.html")
                .build();
    }



//    @Bean
//    public Docket createRestApi(){
//        Predicate<RequestHandler> predicate = new Predicate<RequestHandler>() {
//            @Override
//            public boolean apply(RequestHandler requestHandler) {
//                Class<?> declaringClass = requestHandler.d();
//                return false;
//            }
//        }
//    }
}
