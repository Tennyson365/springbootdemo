package com.yoho.springbootdemo.config;

import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Author: Tennyson
 * E-Mail:wangxing@bailefen.com
 * Project:demo4boot
 * Package:com.yoho.demo.config
 * DateTime: 2017/12/18  15:54
 * Description:shiro权限控制配置
 */
//@Configuration
//@Log4j2
public class ShiroConfiguration {

    /**
     * 处理拦截资源文件
     * filter定义：  1.一个URL可以配置多个Filter，使用逗号隔开
     *              2.当设置多个过滤器时，全部验证通过，方才视为通过
     *              3.部分过滤器可指定参数，如perms，roles
     *
     * @param securityManager
     * @return
     */
//    @Bean
    public ShiroFilterFactoryBean shiroFiler(SecurityManager securityManager){
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        shiroFilterFactoryBean.setSecurityManager((org.apache.shiro.mgt.SecurityManager) securityManager);

        //登录页面
        shiroFilterFactoryBean.setLoginUrl("/login");
        //登录成功页面
        shiroFilterFactoryBean.setSuccessUrl("/index");
        //未授权页面
        shiroFilterFactoryBean.setUnauthorizedUrl("/403");

        //拦截器
        Map<String,String> filterMap = new LinkedHashMap<>();
        filterMap.put("/static/**","anon");
        filterMap.put("/login","anon");
        //登出
        filterMap.put("/logout","logout");

        /*
        * 过滤链
        *  /** 放在最下面
        *  authc    访问需要认证通过
        *  anon     可以匿名访问
        *  user     配置记住我，或者通过认证方可访问
        */
        filterMap.put("/**","authc");

        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterMap);

        return shiroFilterFactoryBean;
    }

//    @Bean
    DefaultSecurityManager securityManager(){
        DefaultSecurityManager securityManager = new DefaultSecurityManager();
        //设置realm
        securityManager.setRealm(userShiroRealm());
        return securityManager;
    }

//    @Bean
    UserShiroRealm userShiroRealm(){
        UserShiroRealm userShiroRealm = new UserShiroRealm();
        return userShiroRealm;
     }

}
